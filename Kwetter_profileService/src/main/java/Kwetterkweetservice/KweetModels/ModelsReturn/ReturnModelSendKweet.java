package Kwetterkweetservice.KweetModels.ModelsReturn;

public class ReturnModelSendKweet {
    private boolean success;
    private String errorMessage;


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
