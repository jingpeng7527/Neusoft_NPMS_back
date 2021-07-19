package com.neusoft.npms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
public class ClientRelate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 当前client
     */
    private Integer clientCurrentId;

    private Integer clientRelateId;

    /**
     * 外键（关联 client_relate_type）
     */
    private Integer clientRelateTypeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientCurrentId() {
        return clientCurrentId;
    }

    public void setClientCurrentId(Integer clientCurrentId) {
        this.clientCurrentId = clientCurrentId;
    }

    public Integer getClientRelateId() {
        return clientRelateId;
    }

    public void setClientRelateId(Integer clientRelateId) {
        this.clientRelateId = clientRelateId;
    }

    public Integer getClientRelateTypeId() {
        return clientRelateTypeId;
    }

    public void setClientRelateTypeId(Integer clientRelateTypeId) {
        this.clientRelateTypeId = clientRelateTypeId;
    }

    @Override
    public String toString() {
        return "ClientRelate{" +
        "id=" + id +
        ", clientCurrentId=" + clientCurrentId +
        ", clientRelateId=" + clientRelateId +
        ", clientRelateTypeId=" + clientRelateTypeId +
        "}";
    }
}
