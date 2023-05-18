package com.kbstar.controller;


import com.kbstar.dto.Product;
import com.kbstar.dto.ProductSearch;
import com.kbstar.service.ProductService;
import com.kbstar.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "shop/";



}