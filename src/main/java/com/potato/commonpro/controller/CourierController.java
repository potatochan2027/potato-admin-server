package com.potato.commonpro.controller;

import com.potato.commonpro.base.JsonResult;
import com.potato.commonpro.model.Courier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourierController {

    @RequestMapping("/courier/list")
    @ResponseBody
    public JsonResult list(){
        List<Courier> courierList=new ArrayList<>();
        Courier courier=new Courier();
        courier.setCourierId(1);
        courier.setCourierName("圆通快递");
        courierList.add(courier);

        Courier courier1=new Courier();
        courier1.setCourierId(2);
        courier1.setCourierName("韵达快递");
        courierList.add(courier1);

        JsonResult model=new JsonResult();
        model.setData(courierList);
        model.setCode(200);
        model.setSuccess(true);
        model.setMsg("获取成功");

        return model;
    }

    public Courier get(){
        Courier courier=new Courier();

        return courier;
    }

}
