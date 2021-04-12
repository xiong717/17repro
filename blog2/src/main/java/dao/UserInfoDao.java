package dao;

import models.Userinfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * userinfo 的数据操作方法
 * 增、删、改、查
 */
public class UserInfoDao {
    /**
     * 添加方法
     * @param userinfo
     * @return
     */
    public boolean add(Userinfo userinfo) throws SQLException {
        boolean result = false;
     if (userinfo.getUsername()!=null && userinfo.getPassword()!= null) {
         //正常的参数
         Connection connection = DBUtils.getConnect();
         String sql = "insert into userinfo(username,password) values(?,?)";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1,userinfo.getUsername());
         statement.setString(2,userinfo.getPassword());
         result = statement.executeUpdate() >= 1 ? true : false;
         //关闭连接
         DBUtils.close(connection,statement,null);
     }
     return result;
    }

    /*
    * 登录方法
    */
   public boolean isLogin(Userinfo userinfo) throws SQLException {
       boolean result = false;
       if (userinfo.getUsername() != null && userinfo.getPassword()!= null
               && !userinfo.getUsername().equals("") && !userinfo.getPassword().equals(""))
       {
           //进来的是正常参数
           //1.连接数据库
           Connection connection = DBUtils.getConnect();
           //2.往数据库写东西
           String sql = "select * from userinfo where username = ? and password = ?";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1,userinfo.getUsername());
           statement.setString(2,userinfo.getPassword());
           ResultSet resultSet = statement.executeQuery();
           if (resultSet.next()){
               result = true;
           }
           //3.关闭数据库
           DBUtils.close(connection,statement,resultSet);
       }
       return result;
   }
}
