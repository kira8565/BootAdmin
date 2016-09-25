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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.supercall.common.ConstantUtility;
import org.supercall.controller.admin.common.BaseController;
import org.supercall.dao.sys.SysMenuDao;
import org.supercall.model.SysMenu;
import org.supercall.validator.sys.MenuValidator;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/sys/menu")
public class MenuController extends BaseController {

    String prefix = "admin/sys/menu/";

    @Autowired
    MenuValidator menuValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(menuValidator);
    }

    @Autowired
    SysMenuDao sysMenuDao;

    @RequestMapping("/index")
    public String index(
            @RequestParam(required = false, defaultValue = "20") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortfields,
            @RequestParam(required = false, defaultValue = "desc") String sortType,
            HttpServletRequest request,
            Model model) {
        PageRequest pages = new PageRequest(page, size, buildSort(sortType, sortfields));
        initListData(sysMenuDao.findAll(buildSpecification(request), pages), model);
        return prefix + "index";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, Model model,
                      @ModelAttribute("sysMenu") SysMenu sysMenu) {
        return prefix + "add";
    }

    @RequestMapping(value = "/addEntity")
    public ModelAndView addEntity(HttpServletRequest request, Model model,
                                  @Valid @ModelAttribute("sysMenu") SysMenu sysMenu,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView(prefix + "add");
        } else {
            ModelAndView modelAndView = new ModelAndView();
            try {
                sysMenuDao.save(sysMenu);
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_SUCCESS_MESSAEG, ConstantUtility.CREATE_SUCCESS);
            } catch (Exception ex) {
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_ERROR_MESSAEG, ConstantUtility.CREATE_FAIL);
            }
            modelAndView.setViewName("redirect:/" + prefix + "index");
            return modelAndView;
        }
    }
}
