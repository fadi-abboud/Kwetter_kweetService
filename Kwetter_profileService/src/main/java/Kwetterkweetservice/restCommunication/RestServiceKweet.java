package Kwetterkweetservice.restCommunication;

import Kwetterkweetservice.KweetManager.KweetManager;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;
import Kwetterkweetservice.KweetModels.ModelsSubmit.SendKweetSubmitModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestServiceKweet {

    @Autowired
    private KweetManager manager = new KweetManager();

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value =  "",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendKweet(@RequestBody String json) throws JsonProcessingException {
        SendKweetSubmitModel submitModel = objectMapper.readValue(json, SendKweetSubmitModel.class);
        if (submitModel.getUser_id() == 0 || submitModel.getMessage().isEmpty()) {
          return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ReturnModelSendKweet returnModel = manager.sendKweet(submitModel.getUser_id(), submitModel.getMessage());

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "", method = RequestMethod.GET)
    public ResponseEntity getKweets() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapper.writeValueAsString(manager.getKweets()));
    }

    @RequestMapping(value =  "/{kweet_id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteKweet(@PathVariable("kweet_id") int kweet_id) throws JsonProcessingException {
        if (kweet_id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ReturnModelSendKweet returnModel = manager.deleteKweet(kweet_id);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/like", method = RequestMethod.POST)
    public ResponseEntity likeKweet() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapper.writeValueAsString(manager.likeKweet()));
    }

    @RequestMapping(value =  "/mentions", method = RequestMethod.GET)
    public ResponseEntity getMentions() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectMapper.writeValueAsString(manager.getMentions()));
    }

    @RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
    public ResponseEntity getKweetsFromUser(@PathVariable("user_id") int user_id) throws JsonProcessingException {
        if (user_id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ReturnModelGetKweetsFrom returnModel = manager.getKweetsFromUser(user_id);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(objectMapper.writeValueAsString(returnModel));
        }
    }
}
