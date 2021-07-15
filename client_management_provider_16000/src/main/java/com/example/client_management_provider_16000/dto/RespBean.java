package com.example.client_management_provider_16000.dto;

import java.io.Serializable;

public class RespBean implements Serializable {

//	消息通知 ：正确消息    错误消息

    //创建 正确消息提示 信息 不包括 封装的实体bean 例如用户信息
    public static RespBean ok(Integer status ,String msg ) {
        return new RespBean(status,msg,null);
    }
    //创建 正确消息提示 信息 包括 封装的实体bean 例如用户信息
    public static RespBean ok(Integer status ,String msg,Object obj ) {
        return new RespBean(status,msg,obj);
    }

    //创建错误消息提示 信息 不包括 封装的实体bean 例如用户信息
    public static RespBean error(Integer status ,String msg ) {
        return new RespBean(status,msg,null);
    }
    //创建错误消息提示 信息 包括 封装的实体bean 例如用户信息
    public static RespBean error(Integer status ,String msg,Object obj  ) {
        return new RespBean(status,msg,obj);
    }


    private RespBean() {

    }

    private RespBean(Integer status, String msg, Object obj) {
//		super();
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    private Integer status;//具体的状态
    private String msg;  //信息提示
    private Object obj; //携带实体bean
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
