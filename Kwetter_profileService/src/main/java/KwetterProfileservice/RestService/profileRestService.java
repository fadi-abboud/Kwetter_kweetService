package KwetterProfileservice.RestService;

import KwetterProfileservice.profileModels.ModelsReturn.*;
import KwetterProfileservice.profileModels.ModelsSubmit.ModelSubmitCreateProfile;
import KwetterProfileservice.profileModels.ModelsSubmit.ModelSubmitSendFollow;
import KwetterProfileservice.profileModels.ModelsSubmit.ModelSubmitUpdateProfile;
import KwetterProfileservice.profileModels.ModelsSubmit.ModelSubmitUploadPicture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import KwetterProfileservice.ProfileManager.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class profileRestService {

    @Autowired
    private ProfileManager profileManager = new ProfileManager();

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value =  "/picture",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadPicture(@RequestBody String json) throws JsonProcessingException {
        ModelSubmitUploadPicture submitModel = objectMapper.readValue(json, ModelSubmitUploadPicture.class);

        int user_id = submitModel.getUser_id();
        String picture = submitModel.getPicture();

        if (user_id == 0 || picture.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnUploadPicture returnModel = profileManager.uploadPicture(user_id, picture);
        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }

    }

    @RequestMapping(value = "",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProfile(@RequestBody String json) throws JsonProcessingException {
        ModelSubmitCreateProfile submitModel = objectMapper.readValue(json, ModelSubmitCreateProfile.class);

        String username = submitModel.getUsername();

        int user_id = submitModel.getUser_id();

        if (username.isEmpty() || user_id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnUploadPicture returnModel = profileManager.createProfile(username, user_id);
        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProfile(@RequestBody String json) throws JsonProcessingException {
        ModelSubmitUpdateProfile submitModel = objectMapper.readValue(json, ModelSubmitUpdateProfile.class);

        int user_id = submitModel.getUser_id();
        String bio = submitModel.getBio();
        String location = submitModel.getLocation();
        String website = submitModel.getWebsite();



        ModelReturnUpdateProfile returnModel = profileManager.updateProfile(user_id, bio, location, website);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/{profile_name}", method = RequestMethod.GET)
    public ResponseEntity getProfile(@PathVariable("profile_name") String profile_name) throws JsonProcessingException {

        if (profile_name.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnGetProfile returnModel = profileManager.getProfile(profile_name);
        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/follow",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity followUser(@RequestBody String json) throws JsonProcessingException {
        ModelSubmitSendFollow submitModel = objectMapper.readValue(json, ModelSubmitSendFollow.class);


        int user_id = submitModel.getUser_id();
        int followed_user_id = submitModel.getFollowed_user_id();

        if (user_id == 0 || followed_user_id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnSendFollow returnModel = profileManager.followUser(user_id, followed_user_id);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/follow",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity UnfollowUser(@RequestBody String json) throws JsonProcessingException {
        ModelSubmitSendFollow submitModel = objectMapper.readValue(json, ModelSubmitSendFollow.class);
        int user_id = submitModel.getUser_id();
        int followed_user_id = submitModel.getFollowed_user_id();

        if (user_id == 0 || followed_user_id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnUpdateProfile returnModel = profileManager.UnfollowUser(user_id, followed_user_id);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/follower/{profile_name}", method = RequestMethod.GET)
    public ResponseEntity getFollowers(@PathVariable("profile_name") String profile_name) throws JsonProcessingException {
        if (profile_name.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnGetFollowers returnModel = profileManager.getFollowers(profile_name);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/followed/{profile_name}", method = RequestMethod.GET)
    public ResponseEntity getFollowed(@PathVariable("profile_name") String profile_name) throws JsonProcessingException {
        if (profile_name.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnGetFollowed returnModel = profileManager.getFollowed(profile_name);


        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

    @RequestMapping(value =  "/stats/{profile_name}", method = RequestMethod.GET)
    public ResponseEntity getStats(@PathVariable("profile_name") String profile_name) throws JsonProcessingException {
        if (profile_name.isEmpty()) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturnGetStats returnModel = profileManager.getStats(profile_name);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }
    @RequestMapping(value =  "/getById/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") int id) throws JsonProcessingException {
        if (id == 0) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }

        ModelReturngetById returnModel = profileManager.getById(id);

        if (returnModel.isSuccess()) {
            return ResponseEntity.status(HttpStatus.OK).body(objectMapper.writeValueAsString(returnModel));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectMapper.writeValueAsString(returnModel));
        }
    }

}
