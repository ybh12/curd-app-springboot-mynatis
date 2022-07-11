package com.travel.form.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.travel.form.data.entity.YangbohaiOrderEntity;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


/**
* @author prent
* @description 针对表【t_order_yangbohai】的数据库操作Service
* @createDate 2022-06-17 21:42:58
*/
public interface YangbohaiOrderService extends IService<YangbohaiOrderEntity> {

    /**
     * 查询订单列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<YangbohaiOrderEntity> listOrder(Integer pageNum, Integer pageSize);


    /**
     * 查询订单
     * @param name
     * @return
     */
    List<YangbohaiOrderEntity> selectOrderByName(String name);


    /**
     * 根据id删除Order
     * @param id
     * @return
     */
    int deleteOrderById(int id);


    /**
     * 更改订单
     * @param yangbohaiOrderEntity
     * @return
     */
    int updateOrder(YangbohaiOrderEntity yangbohaiOrderEntity);


    /**
     *  查询全部Book,返回list集合
     * @return
     */
    List<YangbohaiOrderEntity> queryAllOrder();


    /**
     * 增加订单
     * @param yangbohaiOrderEntity
     * @return
     */
    int addOrder(@RequestBody YangbohaiOrderEntity yangbohaiOrderEntity);
}
