package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *通用数据库 1.对外提供统一的connect对象 2.提供统一的关闭ff
 */
public class DBUtils {
    public static MysqlDataSource dataSource = null;
    //对外提供统一的connect对象
    public static Connection getConnect() throws SQLException {
        if (dataSource == null) {
            //说明是首次调用 先初始化
            dataSource = new MysqlDataSource();
            //1.设置连接服务器的地址
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/java17blog?charactionEncoding=utf-8&useSSL=true");
            //2.设置用户名
            dataSource.setUser("root");
            //3.设置自己的密码
            dataSource.setPassword("111111");
        }
        return dataSource.getConnection();
    }
    //统一关闭方法
    public static void close(Connection connection,
                             PreparedStatement statement,
                             ResultSet resultSet) throws SQLException {
        //从小到大关闭接口
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection!= null) connection.close();
    }
}
