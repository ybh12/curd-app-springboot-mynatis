package com.travel.form.data.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travel.form.utils.json.JsonLocalDateTimeDeserializer;
import com.travel.form.utils.json.JsonLocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author by 李泽阳 on 2022/6/12 19:28
 * @description：
 */
@Data
public class LizyangUserVO {

    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 用户账号
     */
    @ApiModelProperty(value = "user_name")
    private String userName;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "nick_name")
    private String nickName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "password")
    private String password;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "mobile")
    private String mobile;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "email")
    private String email;
    /**
     * 状态
     */
    @ApiModelProperty(value = "status")
    private Integer status;
    /**
     * 类型：0超级管理员 1二级B端管理员，2普通用户
     */
    @ApiModelProperty(value = "type")
    private Integer type;
    /**
     * 头像
     */
    @ApiModelProperty(value = "avatar")
    private String avatar;
    /**
     * 备注
     */
    @ApiModelProperty(value = "remark")
    private String remark;
    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;
    /**
     * token过期时间
     */
    @ApiModelProperty(value = "token_expiration_time")
    @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
    @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
    private LocalDateTime tokenExpirationTime;
    /**
     * B端门店地址
     */
    @ApiModelProperty(value = "address")
    private String address;
    /**
     * 超级管理员id
     */
    @ApiModelProperty(value = "admin_user_id")
    private Long adminUserId;
}
