package Kwetterkweetservice.dataAccessLayer.datacontext;

import Kwetterkweetservice.KweetModels.Kweet;
import Kwetterkweetservice.dataAccessLayer.abstracts.KweetContextAbstract;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;

public class ContextKweetTestAbstract extends KweetContextAbstract {


    @Override
    public ReturnModelSendKweet sendKweet(int user_id, String message) {
        ReturnModelSendKweet ReturnModelKweet = new ReturnModelSendKweet();
        ReturnModelKweet.setSuccess(true);
        return ReturnModelKweet;
    }

    @Override
    public String getMentions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ReturnModelSendKweet deleteKweet(int kweet_id) {
        ReturnModelSendKweet ReturnModelKweet = new ReturnModelSendKweet();
        ReturnModelKweet.setSuccess(true);
        return ReturnModelKweet;
    }

    @Override
    public String likeKweet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getKweets() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ReturnModelGetKweetsFrom getKweetsFromUser(int user_id) {
        ReturnModelGetKweetsFrom returnModelGetKweetsFrom = new ReturnModelGetKweetsFrom();

        Kweet kweet = new Kweet();
        kweet.setKweet_id(0);
        kweet.setUser_id(0);
        kweet.setDate("01-06-2022");
        kweet.setLikes(5);
        kweet.setMessage("that is a test kweet");
        returnModelGetKweetsFrom.addKweet(kweet);

        returnModelGetKweetsFrom.setSuccess(true);

        return returnModelGetKweetsFrom;
    }
}
