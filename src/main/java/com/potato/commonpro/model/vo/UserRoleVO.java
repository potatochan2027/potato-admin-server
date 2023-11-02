package com.potato.commonpro.model.vo;

import com.potato.commonpro.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRoleVO {
    private int uid;
    private List<Role> ids;
}
