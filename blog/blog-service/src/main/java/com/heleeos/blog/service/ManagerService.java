package com.heleeos.blog.service;

import com.heleeos.blog.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.dao.ManagerMapper;

/**
 * 管理员信息数据服务层, t_manager.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
@Service
public class ManagerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 根据用户名和密码获取管理员
     *
     * @param username 用户名
     * @param password 密码
     */
    public Manager login(String username, String password) throws ServiceException {
        try {
            Manager manager = new Manager();
            manager.setUserName(username);
            manager.setPassWord(password);

            return managerMapper.get(manager);
        } catch (Exception e) {
            logger.error(String.format("登录[管理员]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }

    /**
     * 更新管理员的令牌
     * @param id 管理员ID
     * @param token 令牌
     */
    public boolean updateToken(Integer id, String token, String ip) {
        try {
            return true;
//            return managerMapper.updateToken(id, token) == 1;
        } catch (Exception e) {
            logger.error(String.format("更新[管理员令牌]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }
}
