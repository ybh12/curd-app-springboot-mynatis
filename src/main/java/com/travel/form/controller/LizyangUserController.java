package com.travel.form.controller;

import com.travel.form.data.dto.LizyangUserDTO;
import com.travel.form.service.impl.LizyangUserService;
import com.travel.form.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by 李泽阳 on 2022/6/12 18:40
 * @description：
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Api(tags = "用户服务")
public class LizyangUserController {

    @Autowired
    private LizyangUserService listUser;

    /**
     * 分页查询用户列表
     *
     * @param pageNum  页
     * @param pageSize 码
     * @return IPage<AdminUserEntity>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表")
    public Result listUser(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        // 返回查询到用户列表
        return Result.ok(listUser.listUser(pageNum, pageSize));
    }

    /**
     * 新增用户
     *
     * @param addUser 新增用户模型
     * @return vo
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户")
    public Result addUser(@RequestBody LizyangUserDTO addUser) {
        listUser.addUser(addUser);
        return Result.ok();
    }
}
