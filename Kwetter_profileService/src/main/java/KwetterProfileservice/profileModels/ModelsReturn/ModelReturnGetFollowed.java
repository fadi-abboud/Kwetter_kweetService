package KwetterProfileservice.profileModels.ModelsReturn;

import java.util.ArrayList;
import java.util.List;

public class ModelReturnGetFollowed {

    private boolean success;
    private String errorMessage;
    private List<String> followed = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getFollowed() {
        return followed;
    }

    public void addFollowed(String followed) {
        this.followed.add(followed);
    }
}
