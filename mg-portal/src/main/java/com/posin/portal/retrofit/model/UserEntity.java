package com.posin.portal.retrofit.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @ClassName : UserEntity
 * @Description : UserEntity
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 23:33
 */
@Data
@TableName("pfm_user")
public class UserEntity extends Model<UserEntity> {

    @TableId("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField("sex")
    private String sex;
    @TableField("age")
    private int age;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @TableField("sign")
    private String sign;
}
