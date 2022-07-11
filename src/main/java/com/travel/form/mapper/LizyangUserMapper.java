package com.travel.form.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.form.data.entity.LizyangUserEntity;
import com.travel.form.data.vo.LizyangUserVO;

import java.util.List;

/**
 * @author by 李泽阳 on 2022/2/6 1:18
 * @description：
 */
public interface LizyangUserMapper extends BaseMapper<LizyangUserEntity> {

    /**
     * 查询用户列表
     *
     * @param page 页码
     * @return List<AdminUserEntity>
     */
    List<LizyangUserEntity> selectUserByType(Page<LizyangUserEntity> page);
}
