package com.need.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 成绩表
 *
 * @author WangYeKun
 * @date 2019/12/01
 */
@Data
public class Score implements Serializable {
    /**
     * 成绩id
     */
    @ApiModelProperty(value = "成绩id")
    private String sId;

    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id")
    private String cId;

    /**
     * 成绩
     */
    @ApiModelProperty(value = "成绩")
    private String sScore;

    private static final long serialVersionUID = 1L;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getsScore() {
        return sScore;
    }

    public void setsScore(String sScore) {
        this.sScore = sScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", cId=").append(cId);
        sb.append(", sScore=").append(sScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}