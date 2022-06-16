package KwetterProfileservice.profileModels.ModelsSubmit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelSubmitGetProfile {
    @JsonProperty
    private int user_id;

    public int getUser_id() {
        return user_id;
    }
}
