package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class NcpController {
    @Value("${uploadimgdir}")
    String imgpath;
    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {
        //이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        //ncp에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =
                (JSONObject) CFRCelebrityUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj  = (JSONObject)faces.get(0);
        JSONObject celebrity = (JSONObject)obj.get("celebrity");
        String value = (String)celebrity.get("value");
        model.addAttribute("result", value);
        model.addAttribute("center","cfr1");

        return "index";
    }
    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) throws ParseException {
        //이미지 저장한다.
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);
        //ncp에 요청한다.
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result =
                (JSONObject)CFRFaceUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        String emotion_value = "";
        String gender_value = "";
        String pose_value ="";
        String age_value ="";

        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);

        JSONObject emotion = (JSONObject)obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject)obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject)obj.get("pose");
        pose_value = (String)pose.get("value");

        JSONObject age = (JSONObject)obj.get("age");
        age_value = (String)age.get("value");

//        JSONObject values = new JSONObject();
//        values.put("emotion_value",emotion_value);
//        values.put("gender_value",gender_value);
//        values.put("pose_value",pose_value);
//        values.put("age_value",age_value);


        Map<String,String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("pose", pose_value);
        map.put("gender", gender_value);
        map.put("age", age_value);


        model.addAttribute("center","cfr2");
        model.addAttribute("result",map);

        return "index";
    }
    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) throws ParseException {
        //ncp에 요청한다.
        JSONObject result =
                (JSONObject)CFRFaceUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());
        //결과를 받는다.
        String emotion_value = "";
        String gender_value = "";
        String pose_value ="";
        String age_value ="";

        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);

        JSONObject emotion = (JSONObject)obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        JSONObject gender = (JSONObject)obj.get("gender");
        gender_value = (String) gender.get("value");

        JSONObject pose = (JSONObject)obj.get("pose");
        pose_value = (String)pose.get("value");

        JSONObject age = (JSONObject)obj.get("age");
        age_value = (String)age.get("value");

//        JSONObject values = new JSONObject();
//        values.put("emotion_value",emotion_value);
//        values.put("gender_value",gender_value);
//        values.put("pose_value",pose_value);
//        values.put("age_value",age_value);


        Map<String,String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("pose", pose_value);
        map.put("gender", gender_value);
        map.put("age", age_value);

        model.addAttribute("center","pic");
        model.addAttribute("result",map);

        return "index";
    }

}
