package wang.utils.word;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.StaticLog;
import cn.hutool.poi.word.Word07Writer;

import java.awt.*;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 16:10
 * @description word工具类
 */
public class WordUtils {
    public static void main(String[] args) {
        Word07Writer writer = new Word07Writer();
        // 添加段落（标题）
        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
        // 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
        // 写出到文件
        writer.flush(FileUtil.file("d:/wordWrite.docx"));
        // 打印输出成功
        StaticLog.info("#####################输出成功########################");
    }
}
