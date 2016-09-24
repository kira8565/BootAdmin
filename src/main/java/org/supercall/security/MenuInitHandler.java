package org.supercall.security;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Repository;
import org.supercall.dao.sys.SysMenuDao;
import org.supercall.model.SysMenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kira on 2016/9/24.
 */
@Repository
public class MenuInitHandler implements AuthenticationSuccessHandler {

    @Autowired
    SysMenuDao sysMenuDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ArrayList<SysMenu> menuList = Lists.newArrayList(sysMenuDao.findAll());
        httpServletRequest.getSession().setAttribute("_menus", menuList);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/index");
    }
}
