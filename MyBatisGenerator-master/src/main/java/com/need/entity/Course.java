package com.need.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 课程表
 *
 * @author WangYeKun
 * @date 2019/12/01
 */
@Data
public class Course implements Serializable {
    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id")
    private String cId;

    /**
     * 课程名字
     */
    @ApiModelProperty(value = "课程名字")
    private String cName;

    /**
     * 老师id
     */
    @ApiModelProperty(value = "老师id")
    private String tId;

    private static final long serialVersionUID = 1L;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cId=").append(cId);
        sb.append(", cName=").append(cName);
        sb.append(", tId=").append(tId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}