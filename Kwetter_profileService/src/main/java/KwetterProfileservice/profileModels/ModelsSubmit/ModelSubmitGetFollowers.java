package KwetterProfileservice.profileModels.ModelsSubmit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelSubmitGetFollowers {
    @JsonProperty
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
