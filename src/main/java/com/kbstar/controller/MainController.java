package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
   @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/login")
    public String main(Model model){
       model.addAttribute("center","login");
//       센터에는 로그인을 뿌려줘
        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }


    //quics?page=bs01
    //? 는 구분자이다. 서버에 요청하는 명령어이고 물음표, 뒤에는 데이터
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }
}
