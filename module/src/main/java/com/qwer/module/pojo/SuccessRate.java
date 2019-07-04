package com.qwer.module.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 成功率
 *     private String createTime; // 创建时间
 *     private String successTime; // 成功时间
 *     private String weekDay; // 周几
 *     private String platOrderNo; // 平台订单号
 *     private String orderStatus; // 订单状态
 *     private String orderAmount; // 订单金额
 *     private String shopAmountl; // 手续费
 *     private String shopAmount; // 实际入账金额
 *     private String payWayName; // 支付方式
 *     private String payTypeName; // 支付类型
 */

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true) // chin=true 则setter返回值为this，不为void
public class SuccessRate implements Serializable {

    private String createTime; // 创建时间
    private String successTime; // 成功时间
    private String weekDay; // 周几
    private String platOrderNo; // 平台订单号
    private String orderStatus; // 订单状态
    private String orderAmount; // 订单金额
    private String shopAmountl; // 手续费
    private String shopAmount; // 实际入账金额
    private String payWayName; // 支付方式
    private String payTypeName; // 支付类型
}
