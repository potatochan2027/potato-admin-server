package com.potato.commonpro.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseModel {

    @JsonIgnore
    int pageSize=10; //每页数量
    @JsonIgnore
    int currentPage=1;//页数
    @JsonIgnore
    int currentIndex; //当前下标

    public int getCurrentIndex() {
        return (currentPage-1)*pageSize;
    }
}
