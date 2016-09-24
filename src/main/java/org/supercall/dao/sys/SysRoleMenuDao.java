package org.supercall.dao.sys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysRoleMenu;

@Repository
public interface SysRoleMenuDao extends CrudRepository<SysRoleMenu,Integer> {
}
