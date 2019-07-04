package com.xiaokai.kuanrf.entity.manage;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.xiaokai.kuanrf.entity.BaseEntity;

import cn.proem.core.entity.User;

/**
 * 登陆账号信息扩展
 * 
 * @author wuy
 */
@Entity
@Table(name = "rural_manage_user")
public class SysUser extends BaseEntity
{

    private static final long serialVersionUID = -5291564077643211401L;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ForeignKey(name = "null")
    private User user;

    /**
     * 密码的明码，用于短信找回密码
     */
    private String code;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

}
