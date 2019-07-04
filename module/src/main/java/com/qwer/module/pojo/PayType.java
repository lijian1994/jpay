package com.qwer.module.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 支付编码
 *     private Integer id;
 *     private String payCode; // 支付编码
 *     private String team; // 所属团队
 *     private Integer active; // 1：可以测试，0禁止测试
 */

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class PayType implements Serializable {
    private Integer id;
    private String payCode; // 支付编码
    private String team; // 所属团队
    private Integer active; // 1：可以测试，0禁止测试
}
