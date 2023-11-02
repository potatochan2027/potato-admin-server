package com.potato.commonpro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SDictKey {

    private Integer id;

    private Integer dictId;

    private String keyName;

    private String keyValue;

}
