package com.travel.form.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.travel.form.data.entity.LizyangUserEntity;
import com.travel.form.data.entity.YangbohaiOrderEntity;
import com.travel.form.mapper.YangbohaiOrderMapper;
import com.travel.form.service.impl.YangbohaiOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author prent
 * @description 针对表【t_order_yangbohai】的数据库操作Service实现
 * @createDate 2022-06-17 21:42:58
 */
@Service
public class YangbohaiOrderServiceImpl extends ServiceImpl<YangbohaiOrderMapper, YangbohaiOrderEntity> implements YangbohaiOrderService {

    @Autowired
    private YangbohaiOrderMapper yangbohaiOrderMapper;

    @Override
    public IPage<YangbohaiOrderEntity> listOrder(Integer pageNum, Integer pageSize) {
        // 设置分页参数
        Page<YangbohaiOrderEntity> page = new Page<>(pageNum, pageSize);
        // 查询mapper映射结果
        List<YangbohaiOrderEntity> recordAdminUser = yangbohaiOrderMapper.selectOrderByType(page);
        // 将结果返回
        page.setRecords(recordAdminUser);
        return page;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<YangbohaiOrderEntity> selectOrderByName(String name) {
        // 1、自定义sql查询
         return yangbohaiOrderMapper.selectOrderByName(name);
        // 2、用写好的框架查询
//        LambdaQueryWrapper<YangbohaiOrderEntity> queryWrapper = Wrappers.<YangbohaiOrderEntity>lambdaQuery();
//        queryWrapper.eq(YangbohaiOrderEntity::getOrderName,name);
//        List<YangbohaiOrderEntity> yangbohaiOrderEntities = baseMapper.selectList(queryWrapper);
//        return yangbohaiOrderEntities;

    }


    /**
     * 删除订单
     * @param id
     * @return
     */
    @Override
    public int deleteOrderById(int id) {
        yangbohaiOrderMapper.deleteById(id);
        //return yangbohaiOrderMapper.deleteOrderById(id);
        return 1;
    }

    /**
     * 更新订单
     * @param yangbohaiOrderEntity
     * @return
     */
    @Override
    public int updateOrder(YangbohaiOrderEntity yangbohaiOrderEntity) {
        yangbohaiOrderEntity.getId();
       yangbohaiOrderMapper.updateById(yangbohaiOrderEntity);
       // return yangbohaiOrderMapper.updateOrder(yangbohaiOrderEntity);
        return 1;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<YangbohaiOrderEntity> queryAllOrder() {
        return yangbohaiOrderMapper.queryAllOrder();
    }


    /**
     * 添加数据
     * @param yangbohaiOrderEntity
     * @return  //没有使用自己的mapper,没有使用自己的数据库语句
     */
    @Override
    public int addOrder(YangbohaiOrderEntity yangbohaiOrderEntity) {
        int num = yangbohaiOrderMapper.insert(yangbohaiOrderEntity);
        //return yangbohaiOrderMapper.addOrder(yangbohaiOrderEntity);
        return num;
    }


}




