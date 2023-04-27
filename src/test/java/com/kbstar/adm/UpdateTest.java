package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {
        Adm obj = new Adm("admin01","pwd010",100);
        try {
            service.modify(obj);
            log.info("수정정상");
        } catch (Exception e) {
     
               log.info("시스템장애입니다.");

        }
    }

}
