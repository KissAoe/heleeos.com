package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
public class Manager {
    /** 用户ID */
    private Integer id;

    /** 用户名 */
    private String userName;

    /** 密码 */
    private String passWord;

    /** 当前的状态,是否禁用等 */
    private Boolean managerState;

    /** 昵称 */
    private String nickName;

    /** 真实姓名 */
    private String realName;

    /**  */
    private String roleIds;

    /** 头像 */
    private String managerPicture;

    /** 域名 */
    private String hostDomain;

    /**  */
    private String loginToken;

    /** 最后登录时间 */
    private Date loginTime;

    /** 上次登录的IP地址 */
    private String loginIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Boolean getManagerState() {
        return managerState;
    }

    public void setManagerState(Boolean managerState) {
        this.managerState = managerState;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    public String getManagerPicture() {
        return managerPicture;
    }

    public void setManagerPicture(String managerPicture) {
        this.managerPicture = managerPicture == null ? null : managerPicture.trim();
    }

    public String getHostDomain() {
        return hostDomain;
    }

    public void setHostDomain(String hostDomain) {
        this.hostDomain = hostDomain == null ? null : hostDomain.trim();
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }
}