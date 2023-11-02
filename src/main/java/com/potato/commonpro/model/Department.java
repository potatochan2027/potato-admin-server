package com.potato.commonpro.model;


import com.potato.commonpro.base.valid.AddGroup;
import com.potato.commonpro.base.valid.ModifyGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Min(value=1,message = "部门编号不能为空！",groups = {ModifyGroup.class})
    private int id; //编号，自增逐渐

    @NotBlank(message = "部门名称不能为空！",groups = {AddGroup.class})
    private String departmentName; //部门名称

    private int parentId; //上级部门编号

    private String departmentHeadName; //部门负责人姓名
    private String departmentHeadPhone; //部门负责人手机号码
    private String departmentHeadEmail; //部门负责人邮箱

    private String remark; //备注

    @NotNull(message = "启用状态不能为空！",groups = {AddGroup.class})
    private int status; // 启用状态，1-关闭；2-启用

    private List<Department> subDepartmentList; //下级部门列表
}
