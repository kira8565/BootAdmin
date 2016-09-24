package org.supercall.controller.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercall.configuration.ConstantConfiguration;
import org.supercall.model.SysMenu;
import org.supercall.service.example.IndexService;
import org.supercall.service.sys.SysMenuService;

@RequestMapping("/example")
@Controller
public class IndexController {

    @Autowired
    IndexService indexService;

    @Autowired
    SysMenuService sysMenuService;

    @Autowired
    ConstantConfiguration constantConfiguration;

    @RequestMapping("/")
    String index(Model model) {
        indexService.work();
        Iterable<SysMenu> list = sysMenuService.findAll();
        list.forEach(e -> {
            System.out.println(e.getName());
        });
        System.out.println(constantConfiguration.getIsDev());
        return "example/index";
    }
}
