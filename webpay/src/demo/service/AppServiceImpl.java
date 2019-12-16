package demo.service;

import demo.bean.QueryRsp;
import demo.common.AppConstants;
import demo.common.FuncUtil;

import java.util.Map;

/**
 * @author lenovo
 */
public class AppServiceImpl implements AppService {

    @Override
    public QueryRsp queryOrder(Map params) {
        String bizseq = FuncUtil.getMapValue(params, "bizseq");
        QueryRsp rsp = new QueryRsp();
        rsp.initHead();
        rsp.setTrxcode(AppConstants.TRXCODE_QUERYORDER);
        rsp.setBizseq(bizseq);
        //1分钱测试交易
        rsp.setAmount(1);
        //商户个性化的信息
        rsp.setTrxreserve("05##20335584#TN000001#01#440992198709257433####");

        if (bizseq.endsWith("9")) {
            rsp.setRetcode("9999");
            rsp.setRetmsg("非法订单号");
        } else {
            rsp.setRetcode("0000");
            rsp.setRetmsg("SUCCESS");
        }

        return rsp;
    }
}
