package com.potato.commonpro.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Page<T> {

    private List<T> list;

    private int total;

    private int pageSize;

    private int currentPage;

}
