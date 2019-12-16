package demo.bean;

import demo.common.AppConstants;
import demo.common.FuncUtil;

import java.util.Date;


public class BaseRsp {

    public String retcode;
    public String retmsg;

    public String cusid;
    public String appid;
    public String randomstr;
    public String timestamp;

    public String sign;
    public String trxcode;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getRandomstr() {
        return randomstr;
    }

    public void setRandomstr(String randomstr) {
        this.randomstr = randomstr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrxcode() {
        return trxcode;
    }

    public void setTrxcode(String trxcode) {
        this.trxcode = trxcode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void initHead() {
        cusid = AppConstants.CUSID;
        appid = AppConstants.APPID;
        timestamp = FuncUtil.formatTime(new Date(), "yyyyMMddHHmmss");
        randomstr = FuncUtil.getRandcode(8);

    }

    public static BaseRsp getFaildResult(String msg) {
        BaseRsp rsp = new BaseRsp();
        rsp.initHead();
        rsp.setRetcode("0000");
        rsp.setRetmsg(msg);
        return rsp;
    }
}
