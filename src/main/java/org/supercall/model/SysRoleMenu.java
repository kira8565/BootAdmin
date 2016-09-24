package org.supercall.model;

import javax.persistence.*;

/**
 * Created by kira on 2016/9/24.
 */
@Entity
@Table(name = "sys_role_menu", schema = "bootadmin", catalog = "")
public class SysRoleMenu {
    private int id;
    private Integer roleid;
    private Integer menuid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleid")
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "menuid")
    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleMenu that = (SysRoleMenu) o;

        if (id != that.id) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        if (menuid != null ? !menuid.equals(that.menuid) : that.menuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (menuid != null ? menuid.hashCode() : 0);
        return result;
    }
}
