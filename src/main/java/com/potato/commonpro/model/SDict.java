package com.potato.commonpro.model;


import com.potato.commonpro.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SDict extends BaseModel {

    private Integer id;

    private String name;

    private String remark;

}
