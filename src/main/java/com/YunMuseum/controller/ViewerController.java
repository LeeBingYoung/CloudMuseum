package com.YunMuseum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by Test Guo on 2017/4/17.
 */
@Controller
public class ViewerController {
    @RequestMapping("/Viewer")
    public String viewer(){
        return "Viewer";
    }
}
