package org.example;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File pdfFile = new File("./src/main/resources/images/lorem-ipsum.pdf");
        Tesseract tess4j = new Tesseract();
        tess4j.setLanguage("por");
        tess4j.setDatapath("/usr/share/tesseract-ocr/5/tessdata");

        String outputPath = "./src/main/resources/txt/out.txt";

        try {
            String result = tess4j.doOCR(pdfFile);

            // Escrevendo a saída do OCR no arquivo
            FileWriter fileWriter = new FileWriter(outputPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(result);
            bufferedWriter.close();

            System.out.println("Saída do OCR foi salva em: " + outputPath);

        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
