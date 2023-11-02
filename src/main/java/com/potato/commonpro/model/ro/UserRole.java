package com.potato.commonpro.model.ro;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRole {

    private int id;

    private int suid;

    private int rid;


    public UserRole(int suid, int rid) {
        this.suid = suid;
        this.rid = rid;
    }
}
