package com.potato.commonpro.model.ro;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleRouter {

    private int id;

    private int rid;

    private int routerId;

}
