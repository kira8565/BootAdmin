package org.supercall.dao.sys;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysMenu;
import org.supercall.model.SysRoleUser;

import java.util.Iterator;
import java.util.List;

@Repository
public interface SysMenuDao extends PagingAndSortingRepository<SysMenu, Integer>, JpaSpecificationExecutor<SysMenu> {

    @Query("from SysMenu as a where a.pid is null ")
    List<SysMenu> findParentMenus();
}
