package org.supercall.model;

import javax.persistence.*;

/**
 * Created by kira on 2016/9/24.
 */
@Entity
@Table(name = "sys_user", schema = "bootadmin", catalog = "")
public class SysUser {
    private int id;
    private String name;
    private String account;
    private String passwd;

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
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "passwd")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUser sysUser = (SysUser) o;

        if (id != sysUser.id) return false;
        if (name != null ? !name.equals(sysUser.name) : sysUser.name != null) return false;
        if (account != null ? !account.equals(sysUser.account) : sysUser.account != null) return false;
        if (passwd != null ? !passwd.equals(sysUser.passwd) : sysUser.passwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        return result;
    }
}
