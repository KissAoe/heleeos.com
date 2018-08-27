package com.heleeos.blog.dao.mapper;

import com.heleeos.blog.dao.dto.Manager;

/**
 * 管理员表的操作, t_manager.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
public interface ManagerMapper {

    Manager get(Manager manager);

    int update(Manager manager);
}
