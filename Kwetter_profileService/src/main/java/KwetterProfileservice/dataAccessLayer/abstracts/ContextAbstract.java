package KwetterProfileservice.dataAccessLayer.abstracts;

import KwetterProfileservice.profileModels.ModelsReturn.*;


public abstract class ContextAbstract {
    public abstract ModelReturnGetProfile getProfile(String user_id);
    public abstract ModelReturnUpdateProfile updateProfile(int user_id, String bio, String location, String website);
    public abstract ModelReturnUploadPicture uploadPicture(int user_id, String picture);
    public abstract ModelReturnSendFollow followUser(int user_id, int followed_user_id);
    public abstract ModelReturnGetFollowers getFollowers(String profile_name);
    public abstract ModelReturnGetFollowed getFollowed(String profile_name);
    public abstract ModelReturnGetStats getStats(String profile_name);

    public abstract ModelReturnUploadPicture createProfile(String username, int user_id);

    public abstract ModelReturngetById getById(int id);
    public abstract ModelReturnUpdateProfile UnfollowUser(int user_id, int followed_user_id);
}
