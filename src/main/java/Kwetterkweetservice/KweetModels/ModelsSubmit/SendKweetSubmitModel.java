package Kwetterkweetservice.KweetModels.ModelsSubmit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendKweetSubmitModel {

    @JsonProperty("user_id")
    private int user_id;
    @JsonProperty("message")
    private String message;

    public int getUser_id() {
        return user_id;
    }

    public String getMessage() {
        return message;
    }
}
