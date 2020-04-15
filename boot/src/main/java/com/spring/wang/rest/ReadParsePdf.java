package com.spring.wang.rest;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 21:36
 * @description 读取Pdf
 */

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadParsePdf {

    private static String getTextFromPdf() {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream("D:\\c.pdf");
            assert false;
            PDFParser parser = new PDFParser((RandomAccessRead) is);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = ReadParsePdf.getTextFromPdf();
        System.out.println(str);
    }
}
