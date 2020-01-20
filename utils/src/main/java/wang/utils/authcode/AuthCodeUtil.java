package wang.utils.authcode;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.lang.Console;
import cn.hutool.log.StaticLog;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 16:06
 * @description 验证码工具类
 */
public class AuthCodeUtil {
    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");
        // 输出code
        StaticLog.info(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        lineCaptcha.verify("4sta7");

        // 重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
        // 新的验证码
        Console.log(lineCaptcha.getCode());
        // 验证图形验证码的有效性，返回boolean值
        System.out.println("lineCaptcha.verify(\"1234\") = " + lineCaptcha.verify("t46i9"));

        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数(圆圈干扰验证码)
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        // CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/circle.png");
        //验证图形验证码的有效性，返回boolean值
        captcha.verify("1234");

        // 扭曲干扰验证码
        // 定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha2 = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        // ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        // 图形验证码写出，可以写出到文件，也可以写出到流
        captcha2.write("d:/shear.png");
        // 验证图形验证码的有效性，返回boolean值
        captcha2.verify("1234");
    }
}
