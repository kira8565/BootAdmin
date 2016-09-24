package org.supercall.dao.sys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysRole;

@Repository
public interface SysRoleDao extends CrudRepository<SysRole,Integer> {
}
