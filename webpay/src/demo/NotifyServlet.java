package demo;

import demo.common.AppConstants;
import demo.common.FuncUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

import static demo.OrderServlet.getStringStringTreeMap;

public class NotifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NotifyServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到通知");
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        TreeMap<String, String> params = getParams(request);
        try {
            // 接受到推送通知,首先验签
            boolean isSign = FuncUtil.validSign(params, AppConstants.APPKEY);
            System.out.println("验签结果:" + isSign);
            //验签完毕进行业务处理
        } catch (Exception e) {//处理异常
            e.printStackTrace();
        } finally {//收到通知,返回success
            response.getOutputStream().write("success".getBytes());
            response.flushBuffer();
        }
    }

    private TreeMap<String, String> getParams(HttpServletRequest request) {
        return getStringStringTreeMap(request);
    }

}
