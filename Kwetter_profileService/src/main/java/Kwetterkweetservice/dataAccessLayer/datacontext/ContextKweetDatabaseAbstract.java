package Kwetterkweetservice.dataAccessLayer.datacontext;

import Kwetterkweetservice.KweetModels.Kweet;
import Kwetterkweetservice.dataAccessLayer.abstracts.KweetContextAbstract;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;

import java.sql.*;

public class ContextKweetDatabaseAbstract extends KweetContextAbstract {

    private final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Kweet;";
    private static Statement statement;

    public ReturnModelSendKweet sendKweet(int user_id, String message) {
        ReturnModelSendKweet returnModel = new ReturnModelSendKweet();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL sendKweet(?,?)}");
                cstmnt.setInt(1, user_id);
                cstmnt.setString(2, message);

                cstmnt.executeUpdate();

                returnModel.setSuccess(true);
            } catch (SQLException e) {
                returnModel.setSuccess(false);
                returnModel.setErrorMessage(e.toString());
            }
        } catch (SQLException e) {
            returnModel.setErrorMessage(e.getMessage());
            returnModel.setSuccess(false);
        }
        return returnModel;
    }

    public String getMentions() {
        return null;
    }

    public ReturnModelSendKweet deleteKweet(int kweet_id) {
        ReturnModelSendKweet returnModel = new ReturnModelSendKweet();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL deleteKweet(?)}");
                cstmnt.setInt(1, kweet_id);

                cstmnt.executeUpdate();

                returnModel.setSuccess(true);
            } catch (SQLException e) {
                returnModel.setSuccess(false);
                returnModel.setErrorMessage(e.toString());
            }
        } catch (SQLException e) {
            returnModel.setErrorMessage(e.getMessage());
            returnModel.setSuccess(false);
        }
        return returnModel;
    }

    public String likeKweet() {
        return null;
    }

    public String getKweets() {
        return null;
    }

    @Override
    public ReturnModelGetKweetsFrom getKweetsFromUser(int user_id) {
        ReturnModelGetKweetsFrom returnModel = new ReturnModelGetKweetsFrom();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getKweetsByUser(?)}");
                cstmnt.setInt(1, user_id);

                cstmnt.execute();

                ResultSet rs = cstmnt.getResultSet();

                while (rs.next()) {
                    Kweet kweet = new Kweet();
                    kweet.setKweet_id(rs.getInt("kweet_id"));
                    kweet.setUser_id(rs.getInt("user_id"));
                    kweet.setMessage(rs.getString("message"));
                    kweet.setDate(rs.getString("date"));
                    kweet.setLikes(rs.getInt("likes"));
                    returnModel.addKweet(kweet);
                }

                returnModel.setSuccess(true);
            } catch (SQLException e) {
                returnModel.setSuccess(false);
                returnModel.setErrorMessage(e.toString());
            }
        } catch (SQLException e) {
            returnModel.setErrorMessage(e.getMessage());
            returnModel.setSuccess(false);
        }
        return returnModel;
    }
}
