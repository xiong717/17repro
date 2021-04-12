package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 *统一的信息输出类
 */
public class ResultJSONUtils {
    public static void write(HttpServletResponse response,
                             String Jsonstr ) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(Jsonstr);
    }

    public static void writeMap(HttpServletResponse response,
                             HashMap<String,Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();

        writer.println(mapper.writeValueAsString(map));
    }


}
