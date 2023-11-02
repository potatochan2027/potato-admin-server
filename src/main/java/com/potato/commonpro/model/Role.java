package com.potato.commonpro.model;


import com.potato.commonpro.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseModel {
    private int id; //编号
    private String name; //角色名称
    private String remark; //备注
    private int status; //是否启用 1-启用；2-禁用，默认启用
    private String mark; //标识符
}
