package KwetterProfileservice.ProfileManager;

import KwetterProfileservice.dataAccessLayer.repo.ProfileRepository;
import KwetterProfileservice.profileModels.ModelsReturn.*;
import KwetterProfileservice.RabbitMQ.rabbitSender;

public class ProfileManager {

    private rabbitSender rabbitSender = new rabbitSender();

    private ProfileRepository profileRepo = new ProfileRepository();

    public ModelReturnGetProfile getProfile(String profile_name) {
        return profileRepo.getProfile(profile_name);
    }
    public ModelReturnUploadPicture uploadPicture(int user_id, String picture) {return profileRepo.uploadPicture(user_id, picture);}

    public ModelReturnUpdateProfile updateProfile(int user_id, String bio, String location,
                                                  String website) {
        return profileRepo.updateProfile(user_id, bio, location, website);
    }

    public ModelReturnSendFollow followUser(int user_id, int followed_user_id) {
        try {
            rabbitSender.send(followed_user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profileRepo.followUser(user_id, followed_user_id);
    }

    public ModelReturnGetFollowers getFollowers(String profile_name) {
        return profileRepo.getFollowers(profile_name);
    }

    public ModelReturnGetFollowed getFollowed(String profile_name) {
        return profileRepo.getFollowed(profile_name);
    }

    public ModelReturnGetStats getStats(String profile_name) {return profileRepo.getStats(profile_name);}

    public ModelReturnUploadPicture createProfile(String username, int user_id) {
        return profileRepo.createProfile(username, user_id);
    }

    public ModelReturngetById getById(int id) {
        return profileRepo.getById(id);
    }

    public ModelReturnUpdateProfile UnfollowUser(int user_id, int followed_user_id) {
        return profileRepo.UnfollowUser(user_id, followed_user_id);
    }
}
