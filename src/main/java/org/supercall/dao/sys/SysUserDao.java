package org.supercall.dao.sys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.supercall.model.SysUser;

@Repository
public interface SysUserDao extends CrudRepository<SysUser, Integer> {

    @Query("from SysUser as a where a.name=?")
    SysUser findByNameEquals(String userName);
}
