package com.kbstar.ncp;

import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@SpringBootTest
public class CFRFaceTests {
    @Value("${uploadimgdir}")
    String imgpath;
    @Autowired
    CFRFaceUtil cfrFaceUtil;
    @Test
    void contextLoads() throws ParseException {
        String imgname = "ma.jpg";
        JSONObject result = (JSONObject) cfrFaceUtil.getResult(imgpath,imgname);
        log.info(result.toJSONString());
    }

}
