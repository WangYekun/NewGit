package wang.utils.pdf;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;

import java.io.IOException;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/3/23 18:49
 * @description html转为pdf
 */
public class HtmlToPDF {
    public static void main(String[] args) throws IOException, InterruptedException {
        Pdf pdf = new Pdf();

        pdf.addPageFromString("<html><head><meta charset=\"utf-8\"></head><h1>Test</h1></html>");
        pdf.addPageFromUrl("http://www.baidu.com");

        // Add a Table of Contents
        pdf.addToc();

        // The `wkhtmltopdf` shell command accepts different types of options such as global, page, headers and footers, and toc. Please see `wkhtmltopdf -H` for a full explanation.
        // All options are passed as array, for example:
        pdf.addParam(new Param("--no-footer-line"), new Param("--header-html", "file:///header.html"));
        pdf.addParam(new Param("--enable-javascript"));

        // Add styling for Table of Contents
        pdf.addTocParam(new Param("--xsl-style-sheet", "my_toc.xsl"));

        // Save the PDF
        pdf.saveAs("D:/Java/plugins");
    }
}

