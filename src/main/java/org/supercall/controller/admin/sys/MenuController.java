package org.supercall.controller.admin.sys;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.log4j.Logger;
import org.hibernate.engine.internal.JoinSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
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
import java.util.List;

@Controller
@RequestMapping("/admin/sys/menu")
public class MenuController extends BaseController {

    private String prefix = "admin/sys/menu/";

    Logger logger = Logger.getLogger(MenuController.class);

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
            String name, String pid,
            Model model) {
        PageRequest pages = new PageRequest(page, size, buildSort(sortType, sortfields));
        List<Predicate> orPredicates = Lists.newArrayList();

        Specification specifications = (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = null;
            if (Strings.isNullOrEmpty(name) == false) {
                predicate = criteriaBuilder.like(root.get("name").as(String.class), "%" + name + "%");
            }
            if (Strings.isNullOrEmpty(pid) == false) {
                predicate = criteriaBuilder.equal(root.get("pid").as(Integer.class), pid);
            }
            return predicate;
        };
        initListData(sysMenuDao.findAll(specifications, pages), model);
        model.addAttribute("parentMenus", sysMenuDao.findParentMenus());
        return prefix + "index";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, Model model,
                      @ModelAttribute("sysMenu") SysMenu sysMenu) {
        model.addAttribute("parentMenus", sysMenuDao.findParentMenus());
        return prefix + "add";
    }

    @RequestMapping(value = "/addEntity")
    public ModelAndView addEntity(HttpServletRequest request, Model model,
                                  @Valid @ModelAttribute("sysMenu") SysMenu sysMenu,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/" + prefix + "add");
        } else {

            try {
                //默认都有二级菜单
                prebuildSysMenuEntity(sysMenu);
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_SUCCESS_MESSAEG, ConstantUtility.CREATE_SUCCESS);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_ERROR_MESSAEG, ConstantUtility.CREATE_FAIL);
                e.printStackTrace();
            }
            modelAndView.setViewName("redirect:/" + prefix + "index");
        }
        return modelAndView;
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, Model model,
                       @ModelAttribute("sysMenu") SysMenu sysMenu,
                       Integer id) {
        model.addAttribute("parentMenus", sysMenuDao.findParentMenus());
        model.addAttribute("entity", sysMenuDao.findOne(id));
        return prefix + "edit";
    }

    @RequestMapping(value = "/editEntity")
    public ModelAndView editEntity(HttpServletRequest request, Model model,
                                   @Valid @ModelAttribute("sysMenu") SysMenu sysMenu,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/" + prefix + "edit");
        } else {

            try {
                prebuildSysMenuEntity(sysMenu);
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_SUCCESS_MESSAEG, ConstantUtility.UPDATE_SUCCESS);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_ERROR_MESSAEG, ConstantUtility.UPDATE_FAIL);
                e.printStackTrace();
            }
            modelAndView.setViewName("redirect:/" + prefix + "index");
        }
        return modelAndView;
    }

    private void prebuildSysMenuEntity(@Valid @ModelAttribute("sysMenu") SysMenu sysMenu) {
        //默认都有二级菜单
        if (sysMenu.getPid() == null) {
            sysMenu.setLevel(1);
        } else {
            sysMenu.setLevel(3);
        }
        sysMenuDao.save(sysMenu);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request, Model model, Integer id, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            sysMenuDao.delete(id);
            redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_SUCCESS_MESSAEG, ConstantUtility.DELETE_SUCCESS);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ConstantUtility.FLASH_SUCCESS_MESSAEG, ConstantUtility.DELETE_FAIL);
            e.printStackTrace();
        }

        modelAndView.setViewName("redirect:/" + prefix + "index");
        return modelAndView;
    }
}
