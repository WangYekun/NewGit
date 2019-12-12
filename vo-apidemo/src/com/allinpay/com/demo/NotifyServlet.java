package com.allinpay.com.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allinpay.com.demo.bean.BaseRsp;
import com.allinpay.com.demo.bean.QueryRsp;
import com.allinpay.com.demo.common.AppConstants;
import com.allinpay.com.demo.common.FuncUtil;
import com.allinpay.com.demo.service.AppService;
import com.allinpay.com.demo.service.AppServiceImpl;

public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NotifyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method,no deal");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("接收到通知");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		TreeMap<String,String> params = getParams(request);
		try {
			boolean isSign = FuncUtil.validSign(params, AppConstants.APPKEY);// 接受到推送通知,首先验签
			System.out.println("验签结果:"+isSign);
			//验签完毕进行业务处理
		} catch (Exception e) {//处理异常
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{//收到通知,返回success
			response.getOutputStream().write("success".getBytes());
			response.flushBuffer();
		}
	}
	
	private TreeMap<String, String> getParams(HttpServletRequest request){
		TreeMap<String, String> map = new TreeMap<String, String>();
		Map reqMap = request.getParameterMap();
		for(Object key:reqMap.keySet()){
			map.put(key.toString(), ((String[])reqMap.get(key))[0]);
		}
		return map;
	}

}
