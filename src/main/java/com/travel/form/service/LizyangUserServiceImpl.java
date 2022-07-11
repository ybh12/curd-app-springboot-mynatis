package com.travel.form.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.form.data.dto.LizyangUserDTO;
import com.travel.form.data.entity.LizyangUserEntity;
import com.travel.form.mapper.LizyangUserMapper;
import com.travel.form.service.impl.LizyangUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author by 李泽阳 on 2022/6/12 18:45
 * @description：
 */
@Service
public class LizyangUserServiceImpl extends ServiceImpl<LizyangUserMapper, LizyangUserEntity> implements LizyangUserService {


    /**
     * 分页查询用户列表
     *
     * @param pageNum  页
     * @param pageSize 码
     * @return IPage<AdminUserEntity>
     */
    @Override
    public IPage<LizyangUserEntity> listUser(Integer pageNum, Integer pageSize) {
        // 设置分页参数
        Page<LizyangUserEntity> page = new Page<>(pageNum, pageSize);
        // 查询mapper映射结果
        List<LizyangUserEntity> recordAdminOrder = baseMapper.selectUserByType(page);
        // 将结果返回
        page.setRecords(recordAdminOrder);
        return page;
    }


    /**
     * 新增用户
     *
     * @param addUserDTO 新增用户模型
     */
    @Override
    public void addUser(LizyangUserDTO addUserDTO) {
        LizyangUserEntity addUser = new LizyangUserEntity();
        addUser.setUserName(addUserDTO.getUserName());
        BeanUtil.copyProperties(addUserDTO, addUser);
        baseMapper.insert(addUser);
    }


}
