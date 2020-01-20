package wang.utils.qrcode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.hutool.log.StaticLog;

import java.awt.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 15:30
 * @description 二维码工具类
 */
public class QrCodeUtils {

    public static void main(String[] args) {
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());

        // 生成二维码到文件，也可以到流
        QrCodeUtil.generate("https://payapi.bgycc.com/cashier/uc/23bdaf0072aa460fbbdf2d0a52db1758_ja_4",
                config, FileUtil.file("d:/qrcode.jpg"));
        QrCodeUtil.generate(//
                "http://hutool.cn/", //二维码内容
                QrConfig.create().setImg("d:/1.png"), //附带logo
                FileUtil.file("d:/qrcodeWithLogo.jpg")//写出到的文件
        );
        StaticLog.info("###################################,{}",
                QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg")));
    }
}
