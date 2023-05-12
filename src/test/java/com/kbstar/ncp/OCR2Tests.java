package com.kbstar.ncp;

import com.kbstar.util.OCR2Util;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class OCR2Tests {
    @Value("${uploadimgdir}")
    String imgpath;
    //해당 경로에서 이미지가져옴
    @Test
    void contextLoads() {
        JSONObject jo = null;
        jo = (JSONObject) OCR2Util.getResult(imgpath,"ocr.png");
        log.info(jo.toJSONString());
        Map map = OCR2Util.getData(jo);
        log.info(map.values().toString());
    }

}
