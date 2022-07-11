package com.travel.form.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author by 李泽阳 on 2022/6/12 18:38
 * @description：
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("t_user_lizyang")
public class LizyangUserEntity extends BaseEntity {

    @TableId(value = "id")
    private Long id;
    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;
    /**
     * 邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 状态
     */
    @TableField("status")
    private Integer status;
    /**
     * 类型：0超级管理员 1二级B端管理员，2普通用户
     */
    @TableField("type")
    private Integer type;
    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * token
     */
    @TableField("token")
    private String token;
    /**
     * token过期时间
     */
    @TableField("token_expiration_time")
    private LocalDateTime tokenExpirationTime;
    /**
     * B端门店地址
     */
    @TableField("address")
    private String address;
    /**
     * 超级管理员id
     */
    @TableField("admin_user_id")
    private Long adminUserId;

}
