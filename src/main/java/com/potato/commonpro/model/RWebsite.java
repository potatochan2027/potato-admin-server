package com.potato.commonpro.model;


import com.potato.commonpro.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RWebsite extends BaseModel {

    Integer id;

    String url;

    String remark;

    String crawlerType;

}
