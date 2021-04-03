package service;

import dao.ArticleInfoDao;
import models.ArticleInfo;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MyartlistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int state = -1;
     String msg = "";
        List<ArticleInfo> list = null;
        //权限验证
        HttpSession session = request.getSession(false);
        //false 如果当前会话获取失败 就意思没登录 也就不会创建一个新的session
        //true 是如果当前会话获取失败 也会给你创建一个session信息 这样就不能判断你到底登录成功没
        if (session == null || session.getAttribute("userinfo") == null) {
            //用户未登录
            state = 100;
            msg="用户未登录";
        }else {
            //查询个人的文章列表
            UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
            int uid = userInfo.getId();
            //2.去数据库查询列表信息
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                //查询数据库（我的文章）
                list = articleInfoDao.getMyArtList(uid);
                state = 200;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        //返回信息
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        map.put("msg",msg);
        map.put("list",list);
        ResultJSONUtils.writeMap(response,map);
    }
}
