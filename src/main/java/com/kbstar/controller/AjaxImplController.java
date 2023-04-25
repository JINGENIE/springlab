//AjaxImplController

package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }

    @RequestMapping("/getdata")
    public Object getdata() {
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pw01", "james1"));
        list.add(new Cust("id02", "pw02", "james2"));
        list.add(new Cust("id03", "pw03", "james3"));
        list.add(new Cust("id04", "pw04", "james4"));
        list.add(new Cust("id05", "pw05", "james5"));

        // java Object ---> json 변경하려고!!!!
        // JSON(JavaScript Object Notation)
        // [{},{},{},.....]
        JSONArray ja = new JSONArray();
        for (Cust obj : list) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100 + 1);
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName() + i);
            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/checkid")
    public Object checkid(String id) {
        int result = 0;
        if (id.equals("qqq") || id.equals("aaa") || id.equals("sss")) {
            result = 1;
        }
        return result;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) {
        List<Marker> list = new ArrayList<>();
        if (loc.equals("s")) {
            list.add(new Marker(100, "국밥", "http://www.nate.com", 37.379617, 126.977041, "a.jpeg", "s"));
            list.add(new Marker(101, "짬뽕", "http://www.naver.com", 37.377617, 126.973041, "b.jpeg", "s"));
            list.add(new Marker(102, "삼겹살", "http://www.daum.net", 37.376617, 126.971041, "c.jpeg", "s"));

        } else if (loc.equals("b")) {
            list.add(new Marker(103, "국밥", "http://www.nate.com", 35.111495, 129.13933, "a.jpeg", "b"));
            list.add(new Marker(104, "짬뽕", "http://www.naver.com", 35.122495, 129.14933, "b.jpeg", "b"));
            list.add(new Marker(105, "삼겹살", "http://www.daum.net", 35.131495, 129.13133, "c.jpeg", "b"));

        } else if (loc.equals("j")) {
            list.add(new Marker(106, "국밥", "http://www.nate.com", 33.2641205, 126.570076, "a.jpeg", "j"));
            list.add(new Marker(107, "짬뽕", "http://www.naver.com", 33.122495, 126.14933, "b.jpeg", "j"));
            list.add(new Marker(108, "삼겹살", "http://www.daum.net", 33.131495, 126.13133, "c.jpeg", "j"));

        }
        JSONArray ja = new JSONArray();
        for (Marker obj : list) {
            JSONObject jo = new JSONObject();
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }
}