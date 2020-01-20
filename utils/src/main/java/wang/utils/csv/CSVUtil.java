package wang.utils.csv;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.CharsetUtil;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/20 14:11
 * @description CSV读写工具
 */
public class CSVUtil {
    public static void main(String[] args) {
        //指定路径和编码
        CsvWriter writer = CsvUtil.getWriter("D:/Program Files/testWrite.csv", CharsetUtil.CHARSET_UTF_8);
        //按行写出
        writer.write(
                new String[]{"a1", "b1", "c1"},
                new String[]{"a2", "b2", "c2"},
                new String[]{"a3", "b3", "c3"}
        );

        CsvReader reader = CsvUtil.getReader();
        //从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file("D:\\Program Files\\testWrite.csv"));
        List<CsvRow> rows = data.getRows();
        //遍历行
        for (CsvRow csvRow : rows) {
            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
            Console.log(csvRow.getRawList());
        }

    }
}
