package com.allinpay.com.demo;

import com.allinpay.com.demo.bean.BaseRsp;
import com.allinpay.com.demo.bean.QueryRsp;
import com.allinpay.com.demo.common.AppConstants;
import com.allinpay.com.demo.common.FuncUtil;
import com.allinpay.com.demo.service.AppService;
import com.allinpay.com.demo.service.AppServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("get method,no deal");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("接收到请求");
        request.setCharacterEncoding("utf-8");
        TreeMap<String, String> params = getParams(request);
        AppService service = new AppServiceImpl();
        String rspStr = "";
        try {
            //验签成功,进行业务处理
            if (FuncUtil.validSign(params, AppConstants.APPKEY)) {
                QueryRsp rsp = service.queryOrder(params);
                rspStr = FuncUtil.toJsonResult(rsp);
            } else {//验签失败
                rspStr = getDefaultMsg("验签失败");
            }
        } catch (Exception e) {//处理异常
            e.printStackTrace();
            rspStr = getDefaultMsg("处理异常");
        } finally {
            System.out.println("返回数据:" + rspStr);
            if (!FuncUtil.isEmpty(rspStr)) {
                response.getOutputStream().write(rspStr.getBytes("utf-8"));
            }
            response.flushBuffer();
        }
    }

    private String getDefaultMsg(String errmsg) {
        BaseRsp rsp = BaseRsp.getFaildResult(errmsg);
        return FuncUtil.toJsonResult(rsp);
    }

    private TreeMap<String, String> getParams(HttpServletRequest request) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        Map reqMap = request.getParameterMap();
        for (Object key : reqMap.keySet()) {
            map.put(key.toString(), ((String[]) reqMap.get(key))[0]);
        }
        return map;
    }

}
