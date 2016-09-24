package org.supercall.dao.sys;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysMenu;
import org.supercall.model.SysRoleUser;

@Repository
public interface SysMenuDao extends PagingAndSortingRepository<SysMenu,Integer>, JpaSpecificationExecutor<SysMenu> {

}
