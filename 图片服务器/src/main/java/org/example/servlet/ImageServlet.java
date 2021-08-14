package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. @WebServlet
 * 2. 继承HttpServlet
 * 3. 重写doXXX方法
 */
@WebServlet("/image")
@MultipartConfig
public class ImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        try {
            //1. 解析请求数据
            Part p = req.getPart("uploadImage");
//        p.write("E://TMP");//保存文件到服务器本地某个路径
            long size = p.getSize();//获取上传的文件大小
            String contentType = p.getContentType();//获取每个part的数据格式
            String name = p.getSubmittedFileName();//获取上传的文件
            //p.getInputStream();//获取上传文件的输入流（数据）

            //2. 根据请求数据完成业务处理
            //TODO
            //2-1: 保存上传图片为服务端本地文件
            //2-2: 图片信息保存在数据库---->后续查询图片列表接口要用
        }catch (Exception e){
            e.printStackTrace();
            resp.setStatus(500);
            //报错可以往body中写错误信息，如果没有，就只能检查日志
        }

        //3. 返回响应数据

        /*ObjectMapper m = new ObjectMapper();
        Map<String,Object> data = new HashMap<>();
        data.put("size",size/1024);
        data.put("contentType", contentType);
        data.put("name",name);
        String json = m.writeValueAsString(data);
        resp.getWriter().println(json);*/
    }
}
