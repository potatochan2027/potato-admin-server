package com.potato.commonpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouterMeta {
    private int id;
    private String title;
    private String icon;
    private int rank;
    private int sort; //mysql rank是关键字，而前端用的rank，所以用sort字段做中转


    //附带属性
    private List<String> roles;
    private List<String> auths;



}
