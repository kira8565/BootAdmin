package org.supercall.model;

import javax.persistence.*;

/**
 * Created by kira on 2016/9/24.
 */
@Entity
@Table(name = "sys_menu", schema = "bootadmin", catalog = "")
public class SysMenu {
    private int id;
    private String name;
    private String urls;
    private String icons;
    private Integer parentid;

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
    @Column(name = "urls")
    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    @Basic
    @Column(name = "icons")
    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenu sysMenu = (SysMenu) o;

        if (id != sysMenu.id) return false;
        if (name != null ? !name.equals(sysMenu.name) : sysMenu.name != null) return false;
        if (urls != null ? !urls.equals(sysMenu.urls) : sysMenu.urls != null) return false;
        if (icons != null ? !icons.equals(sysMenu.icons) : sysMenu.icons != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (urls != null ? urls.hashCode() : 0);
        result = 31 * result + (icons != null ? icons.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "parentid")
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
