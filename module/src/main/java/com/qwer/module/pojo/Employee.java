package com.qwer.module.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户
 *     private Integer id;
 *     private String username; // 用户名
 *     private String password; // 密码
 *     private Integer authority; // 1 代表普通用户，0代表超管
 *     private String team; // 所属团队
 */

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true) // chin=true 则setter返回值为this，不为void
public class Employee implements Serializable {
    private Integer id;
    private String username; // 用户名
    private String password; // 密码
    private Integer authority; // 1 代表普通用户，0代表超管
    private String team; // 所属团队
}
