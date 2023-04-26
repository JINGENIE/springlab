package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
//    차트02라는 요청이 들어오면 제이슨 데이터를 보낸다.
    public Object chart02(){

        JSONObject jo = new JSONObject();
        JSONArray jaCnt = new JSONArray();
        for(int i = 0; i <= 12; i++){
            Random r = new Random();
            int cnt = r.nextInt(10000)+1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for (int i = 2011; i <= 2023; i++ ) {
            jaYear.add(i);
        }
        jo.put("category", jaYear);
        jo.put("datas", jaCnt);
        //{'category':[], 'datas':[]}
        return jo;
    }
    @RequestMapping("/chart0301")
    public Object chart0301(){
        //[[],[]]
        JSONArray ja = new JSONArray();
        for(int i=1; i<=5; i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:"+num);
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }
    @RequestMapping("/chart0302")
    public Object chart0302(){
        //[[],[]]
        JSONArray ja = new JSONArray();
        for(int i=1; i<=5; i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:"+num);
            jadata.add(num);
            ja.add(jadata);
        }
        //[  ["data:숫자", 숫자], ["data:숫자", 숫자],["data:숫자", 숫자],["data:숫자", 숫자],["data:숫자", 숫자]]
        //이 데이터는 총 다섯 개의 요소로 이루어진 2차원 배열입니다. 각 요소는 다시 1차원 배열로 이루어져 있으며,
        // 첫 번째 요소는 문자열 "data:숫자"와 랜덤한 숫자값을 담고, 두 번째 요소는 랜덤한 숫자값만을 담고 있습니다.
        // 이러한 형태의 데이터는 대개 차트의 X축과 Y축의 데이터를 함께 표시해야 할 때 사용됩니다.
        return ja;
    }
    @RequestMapping("/chart0303")
    public Object chart0303(){

        JSONArray ja = new JSONArray();
        JSONArray data = new JSONArray(); // 1차원 배열 생성
        for(int i=1; i<=180; i++){
            Random r = new Random();
            int num = r.nextInt(200)+1;
            data.add(num); // 1차원 배열에 데이터 추가
        }
        ja.add(data); // series의 data 속성에 1차원 배열 추가
        //[  [숫자1, 숫자2, ..., 숫자180]]
        //이 데이터는 총 하나의 요소로 이루어진 1차원 배열입니다. 배열 안에는 1부터 180까지 랜덤한 숫자값이 순서대로 들어있습니다.
        // 이러한 형태의 데이터는 대개 차트의 Y축에 대응되는 데이터만을 표시할 때 사용됩니다
        return ja;
    }


}
