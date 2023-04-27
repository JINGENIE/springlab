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
class SelectOneTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {
        Adm adm = null;
        try {
            adm = service.get("adm21");
        } catch (Exception e) {
            log.info("error...");
            e.printStackTrace();
        }
    }

}
