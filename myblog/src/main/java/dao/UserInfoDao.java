package dao;

import models.UserInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/**
 * userinfo的数据操作方法
 * 增删改查
 */
public class UserInfoDao {
    //userinfo的数据操作方法
    public boolean add(UserInfo userInfo) throws SQLException {
        boolean result = false;
        if (userInfo.getUsername() != null && userInfo.getPassword() != null) {
            //正常参数
            Connection connection = DBUtils.getConnect();
            String sql = "insert into userinfo(username,password) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getUsername());
            statement.setString(2, userInfo.getPassword());
            result = statement.executeUpdate() >= 1 ? true : false;
            // 关闭连接
            DBUtils.close(connection, statement, null);
        }
        return result;
    }

    public boolean islogin(UserInfo userInfo) throws SQLException {
        boolean result = false;
        if (userInfo.getUsername() != null && userInfo.getPassword() != null
                && !userInfo.getUsername().equals("") && !userInfo.getPassword().equals("")) {
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where username=? and password=? and state = 1";
            PreparedStatement Statement = connection.prepareStatement(sql);
            Statement.setString(1, userInfo.getUsername());
            Statement.setString(2, userInfo.getPassword());
            ResultSet resultSet = Statement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 获取uesrinfo 对象
     */
    public UserInfo getUserInfo(UserInfo userInfo) throws SQLException {
        UserInfo user = new UserInfo();
        //todo非空效验
        if (user.getUsername() != null && user.getPassword() != null
                && !user.getUsername().equals("") && !user.getPassword().equals("")) {
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where uersname=? and password=? and state =1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userInfo.getUsername());
            statement.setString(2, userInfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //获取并设置id
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        }
        return user;
    }
}

