package com.potato.commonpro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Router {

    private int id;
    private String path; //路径
    private String name; //菜单名称
    private String component; //链接文件
    private int parentId; //默认为根菜单
    private int metaId; //

    private RouterMeta meta;
    private List<Router> children;
}
