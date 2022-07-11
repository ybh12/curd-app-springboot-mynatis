package com.travel.form.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travel.form.data.entity.YangbohaiOrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YangbohaiOrderMapper extends BaseMapper<YangbohaiOrderEntity> {


    /**
     * 查询订单列表
     * @param page
     * @return
     */
    List<YangbohaiOrderEntity> selectOrderByType(Page<YangbohaiOrderEntity> page);

    /**
     * 按照名称查询所有
     * @return
     */
    List<YangbohaiOrderEntity> selectOrderByName(@Param("name") String name);

    //根据id删除一个Book
    int deleteOrderById(@Param("Orderid") int id);

    //更新Book
    //int updateOrder(YangbohaiOrderEntity yangbohaiOrderEntity);

    //查询全部Book,返回list集合
    List<YangbohaiOrderEntity> queryAllOrder();

    //增加一个Book
    int addOrder(@Param("order") YangbohaiOrderEntity yangbohaiOrderEntity);







}
