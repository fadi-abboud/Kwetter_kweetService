package KwetterProfileservice.profileModels.ModelsRabbit;

public class ModelRabbitFollowerSubmit {
    private String message = "You have a new follower!";
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
