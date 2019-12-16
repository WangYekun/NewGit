package demo;

import demo.bean.BaseRsp;
import demo.bean.QueryRsp;
import demo.common.AppConstants;
import demo.common.FuncUtil;
import demo.service.AppService;
import demo.service.AppServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("接收到请求");
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        request.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        TreeMap<String, String> params = getParams(request);
        AppService service = new AppServiceImpl();
        String rspStr = "";
        try {
            //验签成功,进行业务处理
            if (FuncUtil.validSign(params, AppConstants.APPKEY)) {
                QueryRsp rsp = service.queryOrder(params);
                System.out.println("====================rsp==================== " + JSONObject.fromObject(rsp));
                rspStr = FuncUtil.toJsonResult(rsp);
            } else {//验签失败
                rspStr = getDefaultMsg("SIGN FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rspStr = getDefaultMsg("HANDLE EXCEPTION");
        } finally {
            System.out.println("RETURN DATA:" + rspStr);
            if (!FuncUtil.isEmpty(rspStr)) {
                response.getOutputStream().write(rspStr.getBytes(StandardCharsets.UTF_8));
            }
            response.flushBuffer();
        }
    }

    private String getDefaultMsg(String errmsg) {
        BaseRsp rsp = BaseRsp.getFaildResult(errmsg);
        return FuncUtil.toJsonResult(rsp);
    }

    private TreeMap<String, String> getParams(HttpServletRequest request) {
        return getStringStringTreeMap(request);
    }

    static TreeMap<String, String> getStringStringTreeMap(HttpServletRequest request) {
        TreeMap<String, String> map = new TreeMap<>();
        Map reqMap = request.getParameterMap();
        for (Object key : reqMap.keySet()) {
            map.put(key.toString(), ((String[]) reqMap.get(key))[0]);
        }
        return map;
    }

}
