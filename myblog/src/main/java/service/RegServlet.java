package service;

import dao.UserInfoDao;
import models.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setCharacterEncoding("utf-8");
     //注意数据类型
     response.setContentType("application/json");

     int state = -1;
     String msg = "";
     String username = request.getParameter("username");
     String password = request.getParameter("password");
     //
     if (username == null || password == null) {
         //参数不正确
         msg = "";
     } else {
         //操作数据库进行插入操作
         UserInfo userInfo = new UserInfo();
         userInfo.setUsername(username);
         userInfo.setPassword(password);
         //调用操作数据库的方法
         UserInfoDao userInfoDao = new UserInfoDao();
         try{
             boolean res = userInfoDao.add(userInfo);
             if (res) {
                 //操作数据成功
                 state = 200;
             }else {
                 //操作数据库失败
                 state = 100;
             }
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
     }

        PrintWriter Writer = response.getWriter();
        Writer.println("{\"state\":" + state + ",\"msg\":\"" + msg + "\"}");
        //对应的是 前端的 JQuery.JSON 接口 function后面的内容
    }
}
