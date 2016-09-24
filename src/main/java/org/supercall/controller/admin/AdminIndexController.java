package org.supercall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    private String prefix = "admin/";

    @RequestMapping("/")
    public String login() {
        return prefix + "login";
    }

    @RequestMapping("/index")
    public String index() {
        return prefix + "index";
    }
}
