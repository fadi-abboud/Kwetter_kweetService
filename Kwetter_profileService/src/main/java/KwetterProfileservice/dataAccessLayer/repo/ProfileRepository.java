package KwetterProfileservice.dataAccessLayer.repo;

import KwetterProfileservice.dataAccessLayer.datacontext.ContextDatabaseAbstract;
import KwetterProfileservice.dataAccessLayer.abstracts.ContextAbstract;
import KwetterProfileservice.profileModels.ModelsReturn.*;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    private static ContextAbstract profileContext;

    public ProfileRepository() {
        this.profileContext = new ContextDatabaseAbstract();
    }

    public ModelReturnGetProfile getProfile(String profile_name) {
        return profileContext.getProfile(profile_name);
    }

    public ModelReturnUpdateProfile updateProfile(int user_id, String bio, String location, String website) {
        return profileContext.updateProfile(user_id, bio, location, website);
    }

    public ModelReturnUploadPicture uploadPicture(int user_id, String picture) {
        return profileContext.uploadPicture(user_id, picture);
    }

    public ModelReturnSendFollow followUser(int user_id, int followed_user_id) {
        return profileContext.followUser(user_id, followed_user_id);
    }

    public ModelReturnGetFollowers getFollowers(String profile_name) {
        return profileContext.getFollowers(profile_name);
    }

    public ModelReturnGetFollowed getFollowed(String profile_name) {
        return profileContext.getFollowed(profile_name);
    }

    public ModelReturnGetStats getStats(String profile_name) { return profileContext.getStats(profile_name);}

    public ModelReturnUploadPicture createProfile(String username, int user_id) {
        return profileContext.createProfile(username, user_id);
    }

    public ModelReturngetById getById(int id) {
        return profileContext.getById(id);
    }

    public ModelReturnUpdateProfile UnfollowUser(int user_id, int followed_user_id) {
        return profileContext.UnfollowUser(user_id, followed_user_id);
    }
}
