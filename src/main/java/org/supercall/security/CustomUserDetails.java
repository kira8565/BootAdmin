package org.supercall.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.supercall.model.SysRole;
import org.supercall.model.SysUser;

import java.util.Collection;
import java.util.List;

/**
 * Created by kira on 2016/9/24.
 */
public class CustomUserDetails implements UserDetails {

    private List<SysRole> roles;
    private SysUser user;

    public CustomUserDetails(SysUser user, List<SysRole> roles) {
        this.user = user;
        this.roles = roles;

        SysRole sysRole = new SysRole();
        sysRole.setRolekey("ADMIN");
        roles.add(sysRole);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null || roles.size() < 1) {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        roles.forEach(e -> commaBuilder.append(e.getRolekey()).append(","));
        String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }

    @Override
    public String getPassword() {
        return user.getPasswd();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
