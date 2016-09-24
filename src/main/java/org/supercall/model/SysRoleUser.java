package org.supercall.model;

import javax.persistence.*;

/**
 * Created by kira on 2016/9/24.
 */
@Entity
@Table(name = "sys_role_user", schema = "bootadmin", catalog = "")
public class SysRoleUser {
    private int id;
    private Integer roleid;
    private Integer userid;

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
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleUser that = (SysRoleUser) o;

        if (id != that.id) return false;
        if (roleid != null ? !roleid.equals(that.roleid) : that.roleid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleid != null ? roleid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }
}
