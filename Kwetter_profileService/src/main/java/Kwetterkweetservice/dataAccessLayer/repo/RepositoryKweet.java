package Kwetterkweetservice.dataAccessLayer.repo;

import Kwetterkweetservice.dataAccessLayer.datacontext.ContextKweetDatabaseAbstract;
import Kwetterkweetservice.dataAccessLayer.datacontext.ContextKweetTestAbstract;
import Kwetterkweetservice.dataAccessLayer.abstracts.KweetContextAbstract;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryKweet {
    private static KweetContextAbstract kweetContext;

    public RepositoryKweet() {
        this.kweetContext = new ContextKweetDatabaseAbstract();
    }

    public RepositoryKweet(boolean test) {
        this.kweetContext = new ContextKweetTestAbstract();
    }

    public ReturnModelSendKweet sendKweet(int user_id, String message) {
        return kweetContext.sendKweet(user_id, message);
    }

    public String getMentions() {
        return kweetContext.getMentions();
    }

    public ReturnModelSendKweet deleteKweet(int kweet_id) {
        return kweetContext.deleteKweet(kweet_id);
    }
    public String likeKweet() {
        return kweetContext.likeKweet();
    }
    public String getKweets() {
        return kweetContext.getKweets();
    }
    public ReturnModelGetKweetsFrom getKweetsFromUser(int user_id) {return kweetContext.getKweetsFromUser(user_id);}

}
