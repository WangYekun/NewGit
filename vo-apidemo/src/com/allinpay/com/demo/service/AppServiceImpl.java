package com.allinpay.com.demo.service;

import java.util.Map;

import com.allinpay.com.demo.bean.QueryRsp;
import com.allinpay.com.demo.common.AppConstants;
import com.allinpay.com.demo.common.FuncUtil;

public class AppServiceImpl implements AppService {

	@Override
	public QueryRsp queryOrder(Map params) {
		// TODO Auto-generated method stub
		String bizseq = FuncUtil.getMapValue(params, "bizseq");
		String trxreserve = FuncUtil.getMapValue(params, "trxreserve");
		QueryRsp rsp = new QueryRsp();
		rsp.initHead();
		rsp.setTrxcode(AppConstants.TRXCODE_QUERYORDER);
		rsp.setBizseq(bizseq);
		rsp.setAmount(1);//1分钱测试交易
		rsp.setTrxreserve("05##文西#广州体育西#15820335584#TN000001#01#440992198709257433####");//商户个性化的信息
		
		if(bizseq.endsWith("9")){
			rsp.setRetcode("9999");
			rsp.setRetmsg("非法订单号");
		}
		else{
			rsp.setRetcode("0000");
			rsp.setRetmsg("处理成功");
		}
		
		return rsp;
	}
}
