package Kwetterkweetservice.dataAccessLayer.abstracts;

import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;

public abstract class KweetContextAbstract {
    public abstract ReturnModelSendKweet sendKweet(int user_id, String message);
    public abstract String getMentions();
    public abstract ReturnModelSendKweet deleteKweet(int kweet_id);
    public abstract String likeKweet();
    public abstract String getKweets();
    public abstract ReturnModelGetKweetsFrom getKweetsFromUser(int user_id);
}
