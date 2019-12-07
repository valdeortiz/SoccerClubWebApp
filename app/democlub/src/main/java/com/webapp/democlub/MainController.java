package com.webapp.democlub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController
{
    @RequestMapping("/hola")
    public static String main()
    {
        return "index";
    }
}