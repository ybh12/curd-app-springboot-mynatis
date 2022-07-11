package com.travel.form.controller;


import com.travel.form.data.entity.YangbohaiOrderEntity;
import com.travel.form.service.impl.YangbohaiOrderService;
import com.travel.form.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
@Api(tags = "订单服务")
public class YangbohaiOrderController {
    @Autowired
    private YangbohaiOrderService listOrder;


    /**
     * 分页查询订单列表
     *
     * @param pageNum  页
     * @param pageSize 码
     * @return IPage<AdminUserEntity>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "订单列表")
    public Result listUser(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize)
    {
        // 返回查询到用户列表
        return Result.ok(listOrder.listOrder(pageNum, pageSize));
    }

    /**
     * 条件查询全部列表   入参：输入的参数
     *
     * @param name 订单名称
     * @return Result
     */
    @GetMapping(value = "/all")  // get post
    @ApiOperation(value = "有条件查询")
    public Result all(@RequestParam String name) { //如果是Get请求使用 @RequestParam
        // 实现业务逻辑的，增删改查，操作
        List<YangbohaiOrderEntity> orderList = this.listOrder.selectOrderByName(name);
        return Result.ok(orderList);
    }

    /**
     * 查询所有列表
     * @return
     */
    @GetMapping("/allOrder")
    @ApiOperation(value = "查询所有")
    public Result list() {
        List<YangbohaiOrderEntity> list = this.listOrder.queryAllOrder();
        return Result.ok(list);
    }


    /**
     * 删除订单
     * @param id
     * @return
     */
    @GetMapping("/deleteOrder/{id}")
    @ApiOperation(value = "删除订单")
    public Result deleteBook(@PathVariable("id") int id) {
        listOrder.deleteOrderById(id);
        return Result.ok();
    }


    /**
     * 添加订单
     * @param yangbohaiOrderEntity
     * @return
     */
    @ApiOperation(value = "添加订单")
    @PostMapping("/addOrder")
    public Result addPaper(YangbohaiOrderEntity yangbohaiOrderEntity) {
        System.out.println(yangbohaiOrderEntity);
        listOrder.addOrder(yangbohaiOrderEntity);
        return Result.ok();
    }


    /**
     * 修改订单
     * @param yangbohaiOrderEntity
     * @return
     */
    @ApiOperation(value = "修改订单")
    @PostMapping("/uppdateOrder")
    public Result updateOrder(@RequestBody YangbohaiOrderEntity yangbohaiOrderEntity) {
        System.out.println(yangbohaiOrderEntity);
        listOrder.updateOrder(yangbohaiOrderEntity);

        return Result.ok();
    }
}







