package com.travel.form.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travel.form.data.dto.LizyangUserDTO;
import com.travel.form.data.entity.LizyangUserEntity;
import com.travel.form.data.entity.YangbohaiOrderEntity;

import java.util.List;

/**
 * @author by 李泽阳 on 2022/6/12 18:45
 * @description：
 */
public interface LizyangUserService {

    /**
     * 分页查询用户列表
     *
     * @param pageNum  页
     * @param pageSize 码
     * @return IPage<AdminUserEntity>
     */
    IPage<LizyangUserEntity> listUser(Integer pageNum, Integer pageSize);

    /**
     * 新增用户
     *
     * @param addUser 新增用户模型
     */
    void addUser(LizyangUserDTO addUser);



}
