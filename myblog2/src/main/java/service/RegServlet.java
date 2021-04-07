package service;

import dao.UserInfoDao;
import models.Userinfo;

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
       response.setContentType("application/json");

       int state = -1;//200表示接口执行成功
       String msg ="";
       //1.接收前端参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        if (username == null || password == null) {
            //参数不正确
            msg = "参数不正确";
        }else {
            //操作数据库进行插入操作
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);

            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                boolean res = userInfoDao.add(userinfo);
                if (res){
                    //操作数据库成功
                    state = 200;
                }else {
                    state = 100;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        writer.println("{\"state\":"+state+",\"msg\":\""+msg+"\"}");

    }
}
