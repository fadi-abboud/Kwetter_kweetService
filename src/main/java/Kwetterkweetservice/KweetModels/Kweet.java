package Kwetterkweetservice.KweetModels;

public class Kweet {
    private int kweet_id;
    private int user_id;
    private String message;
    private String date;
    private int likes;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getKweet_id() {
        return kweet_id;
    }

    public void setKweet_id(int kweet_id) {
        this.kweet_id = kweet_id;
    }
}
