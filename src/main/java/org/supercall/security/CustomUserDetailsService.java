package org.supercall.security;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.supercall.dao.sys.SysRoleDao;
import org.supercall.dao.sys.SysUserDao;
import org.supercall.model.SysRole;
import org.supercall.model.SysUser;

import java.util.List;

@Repository
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser;
        try {
            sysUser = sysUserDao.findByNameEquals(s);
        } catch (Exception e) {
            throw new UsernameNotFoundException("未找到该用户");
        }
        if (sysUser == null) {
            throw new UsernameNotFoundException("未找到该用户");
        } else {
            try {
                List<SysRole> roles = Lists.newArrayList(sysRoleDao.findAll());
                return new CustomUserDetails(sysUser, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("获取角色失败");
            }
        }
    }
}
