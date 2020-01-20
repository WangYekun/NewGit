package wang.utils.image;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

import java.awt.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 14:52
 * @description 图片处理工具类
 */
public class ImagesUtil {

    public static void main(String[] args) {
        // 缩放图片
        ImgUtil.scale(
                FileUtil.file("d:/face.jpg"),
                FileUtil.file("d:/face_result.jpg"),
                0.5f
        );
        // 剪裁图片
        ImgUtil.cut(
                FileUtil.file("d:/face.jpg"),
                FileUtil.file("d:/face_result.jpg"),
                // 裁剪的矩形区域
                new Rectangle(200, 200, 100, 100)
        );
        // 图片转换
        ImgUtil.convert(FileUtil.file("e:/test2.png"), FileUtil.file("e:/test2Convert.jpg"));
        // 彩色转为黑白
        ImgUtil.gray(FileUtil.file("d:/logo.png"), FileUtil.file("d:/result.png"));
        // 添加文字水印
        ImgUtil.pressText(
                FileUtil.file("e:/pic/face.jpg"),
                FileUtil.file("e:/pic/test2_result.png"),
                "版权所有", Color.WHITE,
                new Font("黑体", Font.BOLD, 100), //字体
                0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        );
        // 添加图片水印
        ImgUtil.pressImage(
                FileUtil.file("d:/picTest/1.jpg"),
                FileUtil.file("d:/picTest/dest.jpg"),
                ImgUtil.read(FileUtil.file("d:/picTest/1432613.jpg")), //水印图片
                0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.1f
        );
    }
}
