package com.potato.commonpro.model;

import java.util.Date;

/**
 * 业务流程为
 * 1-批量导入拼多多订单
 * 2-进行快递对账
 * 3-进行售后剔除
 * 4-进行成本绑定
 * 5-结束对账
 *
 * 订单利润计算公式为： 订单利润=订单实收-产品成本-包装耗材-快递费
 * 店铺利润计算公式为： 店铺利润=订单利润总和-推广费-店铺杂费（平台费率、运费险等）
 * 总利润计算公式为： 总利润=各店铺利润总和-当月杂费
 */
public class PddOrder {

    /**
     * 平台 &店铺信息
     */
    private int platformId; // 平台编号
    private String platformName; //平台名称
    private int storeId; // 店铺编号
    private String storeName; //店铺名称

    private String orderId; //订单编号，以电商平台的编号为准
    private Date payTime; //支付时间，精确到秒

    private double money; //订单实收金额
    private int count; //商品数量

    /**
     * 商品信息
     */
    private String linkId; //链接编号
    private String linkName; //链接名称
    private String skuId; //编号
    private String skuName; // SKU名称
    private String skuCost;// SKU成本
    private String skuPackCost; // SKU包装耗材

    private String preWeight; // SKU重量
    private double preCourierCost; //预估快递费

    /**
     * 物流信息
     */
    private String courierNumber; //快递单号
    private String courierName; //快递公司
    private int courierId; //快递公司编号
    private double courierWeight;// 快递重量
    private double courierFee; //快递费

    /**
     * 通用信息
     */
    private Date CRTime; // 记录创建时间
    private Date MRTime; //记录变更时间





}
