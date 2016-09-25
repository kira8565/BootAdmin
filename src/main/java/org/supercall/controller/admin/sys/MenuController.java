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
import org.supercall.controller.admin.common.BaseController;
import org.supercall.dao.sys.SysMenuDao;
import org.supercall.model.SysMenu;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/sys/menu")
public class MenuController extends BaseController {

    String prefix = "admin/sys/menu/";

    @Autowired
    SysMenuDao sysMenuDao;

    @RequestMapping("/index")
    public String index(
            @RequestParam(required = false, defaultValue = "1") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortfields,
            @RequestParam(required = false, defaultValue = "desc") String sortType,
            HttpServletRequest request,
            Model model) {
        PageRequest pages = new PageRequest(page, size, buildSort(sortType, sortfields));
        initListData(sysMenuDao.findAll(buildSpecification(request), pages), model);
        return prefix + "index";
    }
}
