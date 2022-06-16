package KwetterProfileservice.dataAccessLayer.datacontext;

import KwetterProfileservice.dataAccessLayer.abstracts.ContextAbstract;
import KwetterProfileservice.profileModels.ModelsReturn.*;


import java.sql.*;

public class ContextDatabaseAbstract extends ContextAbstract {

    private final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=profile;user=fadi;password=Kwetter2022;";
    private static Statement statement;

    public void closeConnection() {
        // TODO Auto-generated method stub

    }


    public ModelReturnGetProfile getProfile(String profile_name) {
        ModelReturnGetProfile returnModel = new ModelReturnGetProfile();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getProfile(?)}");
                cstmnt.setString(1, profile_name);

                cstmnt.execute();
                ResultSet rs = cstmnt.getResultSet();
                if (rs.next()) {
                    returnModel.setUser_id(rs.getInt("user_id"));
                    returnModel.setBio(rs.getString("bio"));
                    returnModel.setLocation(rs.getString("location"));
                    returnModel.setProfile_name(rs.getString("profile_name"));
                    returnModel.setPicture(rs.getString("picture"));
                    returnModel.setWebsite(rs.getString("website"));
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

    @Override
    public ModelReturnUpdateProfile updateProfile(int user_id, String bio, String location, String website) {
        ModelReturnUpdateProfile returnModel = new ModelReturnUpdateProfile();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL uploadProfile(?,?,?,?)}");
                cstmnt.setInt(1, user_id);
                cstmnt.setString(2, bio);
                cstmnt.setString(3, location);
                cstmnt.setString(4, website);

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

    @Override
    public ModelReturnUploadPicture uploadPicture(int user_id, String picture) {

        ModelReturnUploadPicture returnModel = new ModelReturnUploadPicture();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL uploadPicture(?,?)}");
                cstmnt.setInt(1, user_id);
                cstmnt.setString(2, picture);

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

    public ModelReturnSendFollow followUser(int user_id, int followed_user_id) {
        ModelReturnSendFollow returnModel = new ModelReturnSendFollow();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL followUser(?,?)}");
                cstmnt.setInt(1, user_id);
                cstmnt.setInt(2, followed_user_id);

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

    public ModelReturnUpdateProfile UnfollowUser(int user_id, int followed_user_id) {
        ModelReturnUpdateProfile returnModel = new ModelReturnUpdateProfile();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL UnfollowUser(?,?)}");
                cstmnt.setInt(1, user_id);
                cstmnt.setInt(2, followed_user_id);

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

    @Override
    public ModelReturnGetFollowers getFollowers(String profile_name) {
        ModelReturnGetFollowers returnModel = new ModelReturnGetFollowers();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getFollowers(?)}");
                cstmnt.setString(1, profile_name);
                cstmnt.execute();
                ResultSet rs = cstmnt.getResultSet();
                while (rs.next()) {
                    returnModel.addFollower(rs.getString("profile_name"));
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

    @Override
    public ModelReturnGetFollowed getFollowed(String profile_name) {
        ModelReturnGetFollowed returnModel = new ModelReturnGetFollowed();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getFollowed(?)}");
                cstmnt.setString(1, profile_name);
                cstmnt.execute();
                ResultSet rs = cstmnt.getResultSet();
                while (rs.next()) {
                    returnModel.addFollowed(rs.getString("profile_name"));
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

    @Override
    public ModelReturnGetStats getStats(String profile_name) {
        ModelReturnGetStats returnModel = new ModelReturnGetStats();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getCountFollowed(?)}");
                cstmnt.setString(1, profile_name);

                cstmnt.execute();
                ResultSet rs = cstmnt.getResultSet();
                while (rs.next()) {
                    returnModel.setFollowed(rs.getInt("followed"));
                }

                CallableStatement cstmnt2 = connection.prepareCall("{CALL getCountFollowers(?)}");
                cstmnt2.setString(1, profile_name);

                cstmnt2.execute();
                ResultSet rs2 = cstmnt2.getResultSet();
                while (rs2.next()) {
                    returnModel.setFollowers(rs2.getInt("followers"));
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

    @Override
    public ModelReturnUploadPicture createProfile(String username, int user_id) {
        ModelReturnUploadPicture returnModel = new ModelReturnUploadPicture();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL createProfile(?,?)}");
                cstmnt.setString(1, username);
                cstmnt.setInt(2, user_id);

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

    @Override
    public ModelReturngetById getById(int id) {
        ModelReturngetById returnModel = new ModelReturngetById();
        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            try {
                CallableStatement cstmnt = connection.prepareCall("{CALL getById(?)}");
                cstmnt.setInt(1, id);

                cstmnt.execute();
                ResultSet rs = cstmnt.getResultSet();
                while (rs.next()) {
                    returnModel.setUsername(rs.getString("profile_name"));
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
