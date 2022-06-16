package Kwetterkweetservice.KweetManager;

import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.dataAccessLayer.repo.RepositoryKweet;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;

public class KweetManager {

    private RepositoryKweet RepoKweet = new RepositoryKweet();

    public ReturnModelSendKweet sendKweet(int user_id, String message) {
        return RepoKweet.sendKweet(user_id, message);
    }
    public String getMentions() {return RepoKweet.getMentions();}
    public ReturnModelSendKweet deleteKweet(int kweet_id) {return RepoKweet.deleteKweet(kweet_id);}
    public String likeKweet() {return RepoKweet.likeKweet();}
    public String getKweets() {return RepoKweet.getKweets();}
    public ReturnModelGetKweetsFrom getKweetsFromUser(int user_id) { return RepoKweet.getKweetsFromUser(user_id);}
}
