package com.qwer.module.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 支付产品，根据这个类的设置的参数，来生成对应的成功率
 *     private Integer id;
 *     private String payWayName; // 支付方式
 *     private String payTypeName; // 支付类型
 *
 *     private String max; // 最大金额
 *     private String min; // 最小金额
 *     private Integer role; // 支付规则
 *     private String amountList; // 固定金额列表
 *     private Integer employeeId; // 绑定用户id
 *     private Double rate; //费率
 *     private String team; // 所属团队
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true) // chin=true 则setter返回值为this，不为void
public class Product implements Serializable {

    private Integer id;
    private String payWayName; // 支付方式
    private String payTypeName; // 支付类型

    private String max; // 最大金额
    private String min; // 最小金额
    private Integer role; // 支付规则
    private String amountList; // 固定金额列表
    private Integer employeeId; // 绑定用户id
    private Double rate; //费率
    private String team; // 所属团队
}
