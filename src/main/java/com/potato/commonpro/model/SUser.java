package com.potato.commonpro.model;


import com.potato.commonpro.base.BaseModel;
import com.potato.commonpro.base.valid.AddGroup;
import com.potato.commonpro.base.valid.OtherGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SUser extends BaseModel {

    private int id;

    @NotBlank(message="用户名不能为空",groups={OtherGroup.class, AddGroup.class})
    private String username; //后台用户名

    @NotBlank(message="密码不能为空",groups={OtherGroup.class, AddGroup.class})
    private String password; //密码

    private String accessToken; //登录token

    private String refreshToken; //刷新Token

    private Date expires; //token过期时间

    private List<String> roles;//角色列表

    private int deptId; //部门ID

}
