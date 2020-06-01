package com.zwp.myqqbot.constant;

/**
 * 保存地址的常量类
 */
public class URLConst {
    /**
     * HTTP服务器地址
     */
    public static final String URL = "http://127.0.0.1:5700";

    /**
     * 发送私聊消息
     */
    public static final String SEND_PRIVATE_MSG = "/send_private_msg";

    /**
     * 发送群消息
     */
    public static final String SEND_GROUP_MSG = "/send_group_msg";

    /**
     * 获取群列表
     */
    public static final String GET_GROUP_LIST = "/get_group_list";


    //-----------------------------------垃圾分类-----------------------------------
    /**
     * 获取该垃圾的分类,后面加垃圾名称的URL编码
     */
    public static final String GET_RUBBISH_TYPE = "https://lajifenleiapp.com/sk/";


    //-------------------------------------KMZ-------------------------------------
    /**
     * 花瓣网上mz的首页
     */
    public static final String HUABAN_MZ_INDEX = "https://huaban.com/boards/481662/";

    /**
     * mz图URL的前缀，后面加key
     */
    public static final String MZ_IMG_PREFIX = "https://hbimg.huabanimg.com/";

    //-------------------------------------csdn-------------------------------------
    /**
     * csdn主页地址
     */
    public static final String CSDN_HOME = "https://blog.csdn.net/qq_33591903";
}
