package org.supercall.model;

import javax.persistence.*;

/**
 * Created by kira on 2016/9/24.
 */
@Entity
@Table(name = "sys_role", schema = "bootadmin", catalog = "")
public class SysRole {
    private int id;
    private String name;
    private String comment;
    private String rolekey;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRole sysRole = (SysRole) o;

        if (id != sysRole.id) return false;
        if (name != null ? !name.equals(sysRole.name) : sysRole.name != null) return false;
        if (comment != null ? !comment.equals(sysRole.comment) : sysRole.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "rolekey")
    public String getRolekey() {
        return rolekey;
    }

    public void setRolekey(String rolekey) {
        this.rolekey = rolekey;
    }
}
