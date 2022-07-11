package com.travel.form.data.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDateTime;




/**
 * 
 * @TableName t_order_yangbohai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName(value ="t_order_yangbohai")
public class YangbohaiOrderEntity extends BaseEntity {
    /**
     * 主键id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单名称
     */
    @TableField("order_name")
    private String orderName;

    /**
     * 支付费用
     */
    @TableField("payment")
    private String payment;

    /**
     * 邮费
     */
    @TableField("post_fee")
    private String postFee;

    /**
     * 支付方式
     */
    @TableField("payment_type")
    private Integer paymentType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除
     */
    private Integer delFlag;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}