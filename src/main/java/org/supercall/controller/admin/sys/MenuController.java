package org.supercall.controller.admin.sys;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercall.dao.sys.SysMenuDao;
import org.supercall.model.SysMenu;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Controller
@RequestMapping("/admin/sys/menu")
public class MenuController {

    String prefix = "admin/sys/menu/";

    @Autowired
    SysMenuDao sysMenuDao;

    @RequestMapping("/index")
    public String index(
            @RequestParam(required = false, defaultValue = "1") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortfields,
            @RequestParam(required = false, defaultValue = "desc") String sortType,
            @RequestParam(required = false) String name,
            Model model) {
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

        Sort sort;
        if (sortType.equals("desc")) {
            sort = new Sort(Sort.Direction.DESC, sortfields);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortfields);
        }
        PageRequest pages = new PageRequest(page, size, sort);
        Page<SysMenu> result = sysMenuDao.findAll(specifications, pages);
        model.addAttribute("list", result.getContent());
        model.addAttribute("_totalPages", result.getTotalPages());
        model.addAttribute("_totalRecord", result.getTotalElements());
        model.addAttribute("_size", result.getSize());
        model.addAttribute("_number", result.getNumber());
        return prefix + "index";
    }
}
