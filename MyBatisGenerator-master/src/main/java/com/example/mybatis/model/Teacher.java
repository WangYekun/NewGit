package com.example.mybatis.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 教师表
 *
 * @author shawn
 * @date 2019/12/01
 */
@Data
public class Teacher implements Serializable {
    /**
    *教师id
    */
    @ApiModelProperty(value = "教师id")
    private String tId;

    /**
    *教师名字
    */
    @ApiModelProperty(value = "教师名字")
    private String tName;

    private static final long serialVersionUID = 1L;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tName=").append(tName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}