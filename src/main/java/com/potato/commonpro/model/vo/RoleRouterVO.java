package com.potato.commonpro.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleRouterVO {

    private int roleId;

    private List<Integer> routerList;

}
