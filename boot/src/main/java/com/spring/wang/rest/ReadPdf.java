package com.spring.wang.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 20:24
 * @description 读取PDF文档
 */
@RestController
@RequestMapping("/read")
public class ReadPdf {

    public static String file_path = "E:\\test\\test-1.1.0-手册.pdf";

    @RequestMapping(value = "/readPdf")
    public String readPdf(HttpServletResponse response, HttpServletRequest request) throws IOException {

//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/pdf;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        // Create a PdfDocument instance
//        PdfDocument doc = new PdfDocument();
//
//        try {
//            // Load an existing document
//            ("sample_doc1.pdf");
//            // Get page count and display it on console output
//            System.out.println("Number of pages in sample_doc1.pdf is " + doc.getPageCount());
//            // Close document
//            doc.close();
//        } catch (IOException | PdfException e) {
//            e.printStackTrace();
//        }
//        out.flush();
//        out.close();


        // 获取PDF内纯文本信息

/*
        FileInputStream instream = new FileInputStream(filename); // 根据指定文件创建输入流

        PDFParser parser = new PDFParser((RandomAccessRead) instream); // 创建PDF解析器

        parser.parse(); // 执行PDF解析过程


        PDDocument pdfdocument = parser.getPDDocument(); // 获取解析器的PDF文档对象

        PDFTextStripper pdfstripper = new PDFTextStripper(); // 生成PDF文档内容剥离器

        String contenttxt = pdfstripper.getText(pdfdocument); // 利用剥离器获取文档


        System.out.println("文件长度: " + contenttxt.length() + "\n");

        return contenttxt;
*/

        return null;
//    }


    }

}
