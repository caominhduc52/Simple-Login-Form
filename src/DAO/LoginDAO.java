package DAO;

import Bean.Users;
import DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoginDAO {
    public static boolean check(Users users) {
        Connection connection = null;
        PreparedStatement pstm = null;
        List<Users> userList = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM account";
            pstm = connection.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()) {
                Users dummyUser = new Users();
                dummyUser.setId(rs.getInt("id"));
                dummyUser.setUserName(rs.getString("username"));
                dummyUser.setPassWord(rs.getString("password"));
                userList.add(dummyUser);
            }
            rs.close();
            pstm.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex ){
                ex.printStackTrace();
            }
        }
        return userList.stream()
                .filter(s -> s.getUserName().equals(users.getUserName()) && s.getPassWord().equals(users.getPassWord()))
                .collect(Collectors.toList()).size() == 0 ? false : true;

    }
}
