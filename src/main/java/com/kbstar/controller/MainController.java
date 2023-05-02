package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    CustService custService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RequestMapping("/")
    public String main(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }
    @RequestMapping("/logout")
    public String login(Model model, HttpSession ssession){
        if(ssession != null){
            ssession.invalidate();
        }
        return "index";
    }
    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust = null;
        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("system error");
        }
        model.addAttribute("custinfo",cust);
        model.addAttribute("center","custinfo");
        return "index";
    }
    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("system error");
        }
        return "redirect:/custinfo?id=" + cust.getId();
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        logger.info("------------------------------"+id+" "+pwd);
        Cust cust = null;
        String nextPage = "loginfailed";
        try {
            cust = custService.get(id);
            if(cust != null && encoder.matches(pwd, cust.getPwd())){
                nextPage= "loginok";
                session.setMaxInactiveInterval(100000);
                session.setAttribute("logincust", cust);
                //logincust라는 이름으로 cust를 넣어준다.
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애. 잠시 후 다시 로그인 하세여");
        }
        model.addAttribute("center",nextPage);
        return "index";
    }
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               Cust cust, HttpSession session) throws Exception {
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.register(cust);
            session.setAttribute("logincust",cust);
        } catch (Exception e) {
            throw new Exception("register error");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center","registerok");
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }


    // /quics?page=bs01
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }
}
