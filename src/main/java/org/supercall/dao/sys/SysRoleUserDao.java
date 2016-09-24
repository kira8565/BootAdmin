package org.supercall.dao.sys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysRoleUser;

@Repository
public interface SysRoleUserDao extends CrudRepository<SysRoleUser,Integer> {
}
