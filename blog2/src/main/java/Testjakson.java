import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Userinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testjakson {
    public static void main(String[] args) throws JsonProcessingException {
        //演示jakson的使用方法
        Map<String, Object> map = new HashMap<>();
        map.put("state",200);
        map.put("msg","操作成功");

        List<Userinfo> list = new ArrayList<>();
        for (int i = 0; i<3;i++) {
            Userinfo userinfo = new Userinfo();
            userinfo.setUsername("java"+i);
            userinfo.setPassword("pwd"+i);
            list.add(userinfo);
        }
        //Jackson使用
        //1.创建jackson对象
        ObjectMapper mapper = new ObjectMapper();

        String res = mapper.writeValueAsString(map);
        System.out.println(res);

        String result = mapper.writeValueAsString(list);
        System.out.println(result);
    }


}
