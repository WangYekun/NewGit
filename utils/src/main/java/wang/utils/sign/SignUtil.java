package wang.utils.sign;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 15:14
 * @description 签名验证工具
 */
public class SignUtil {
    public static void main(String[] args) {
        byte[] data = "我是一段测试字符串".getBytes();
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        //签名
        byte[] signed = sign.sign(data);
        //验证签名
        boolean verify = sign.verify(data, signed);
        System.out.println("verify = " + verify);
    }
}
