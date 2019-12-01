package com.need.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生表
 *
 * @author WangYeKun
 * @date 2019/12/01
 */
@Data
public class Student implements Serializable {
    /**
     * 学生id
     */
    @ApiModelProperty(value = "学生id")
    private String sId;

    /**
     * 学生名称
     */
    @ApiModelProperty(value = "学生名称")
    private String sName;

    /**
     * 学生生日
     */
    @ApiModelProperty(value = "学生生日")
    private String sBirth;

    /**
     * 学生性别
     */
    @ApiModelProperty(value = "学生性别")
    private String sSex;

    private static final long serialVersionUID = 1L;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", sName=").append(sName);
        sb.append(", sBirth=").append(sBirth);
        sb.append(", sSex=").append(sSex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}