package Kwetterkweetservice.KweetModels.ModelsReturn;

import Kwetterkweetservice.KweetModels.Kweet;

import java.util.ArrayList;
import java.util.List;

public class ReturnModelGetKweetsFrom {
    private List<Kweet> kweets = new ArrayList<>();
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

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void addKweet(Kweet kweet) {
        this.kweets.add(kweet);
    }
}
