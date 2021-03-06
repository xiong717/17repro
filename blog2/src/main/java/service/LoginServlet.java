package service;

import dao.UserInfoDao;
import models.Userinfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int state = -1;
        String msg = "";
        //1.接收前端 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null && password == null) {
            //参数不正确
            msg = "参数不正确";
        }else {
            //参数正确
            //2.执行数据库操作 调用数据库验证用户名和密码
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                state = userInfoDao.isLogin(userinfo)?200:100;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //3.将信息返回给前台
        HashMap<String,Object> result = new HashMap<>();
        result.put("state",state);
        result.put("msg",msg);
        ResultJSONUtils.writeMap(response,result);
    }
}
