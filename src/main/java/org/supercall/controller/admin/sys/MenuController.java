package org.supercall.controller.admin.sys;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.supercall.dao.sys.SysMenuDao;
import org.supercall.model.SysMenu;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;

@Controller
@RequestMapping("/admin/sys/menu")
public class MenuController {

    String prefix = "admin/sys/menu/";

    @Autowired
    SysMenuDao sysMenuDao;

    @RequestMapping("/listData")
    @ResponseBody
    public String listData(@RequestParam(required = false) Integer limit,
                           @RequestParam(required = false) Integer offset,
                           @RequestParam(required = false) String name) {
        Specification<SysMenu> specifications = new Specification<SysMenu>() {
            @Override
            public Predicate toPredicate(Root<SysMenu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = null;
                if (!Strings.isNullOrEmpty(name)) {
                    predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
                }
                return predicate;
            }
        };
        return JSON.toJSONString(Lists.newArrayList(sysMenuDao.findAll(specifications)));
    }

    @RequestMapping("/index")
    public String index() {
        return prefix + "index";
    }
}
