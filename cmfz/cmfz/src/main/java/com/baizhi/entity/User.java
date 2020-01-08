package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-01-03 18:47:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    
    private String name;

    private String sex;
    
    private String province;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date create_Date;

    private String img;
    private String username;
    private String password;

    private String value;


}