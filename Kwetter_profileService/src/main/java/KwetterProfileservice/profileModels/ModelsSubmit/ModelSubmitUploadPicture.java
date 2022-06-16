package KwetterProfileservice.profileModels.ModelsSubmit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelSubmitUploadPicture {
    @JsonProperty
    private int user_id;

    @JsonProperty
    private String picture;

    public String getPicture() {
        return picture;
    }

    public int getUser_id() {
        return user_id;
    }
}
