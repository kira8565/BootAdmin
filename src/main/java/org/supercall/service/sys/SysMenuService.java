package org.supercall.service.sys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.supercall.model.SysMenu;

@Transactional
public interface SysMenuService extends CrudRepository<SysMenu, Long> {
}
