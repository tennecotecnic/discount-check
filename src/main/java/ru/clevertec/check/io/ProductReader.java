package ru.clevertec.check.io;

import ru.clevertec.check.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class ProductReader {

    private final String FINAL_NAME = "c:\\Users\\Titanium\\Desktop\\products.csv";


    public Product findById(int id){
        Product product = null;
        boolean isProductFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String lineFromFile = reader.readLine(); //???????????????? как убрать костыль?
            while(!isProductFound && (lineFromFile = reader.readLine()) != null) {
                   //lineFromFile = reader.readLine();
                    String [] productInfo = lineFromFile.split(";");
                    int idProductFromLine = Integer.parseInt(productInfo[0]);
                    if (id == idProductFromLine) {
                        isProductFound = true;
                        String descriptionProductFromFile = productInfo[1];
                        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                        symbols.setDecimalSeparator(',');
                        DecimalFormat decimalFormat = new DecimalFormat("#.00");
                        decimalFormat.setDecimalFormatSymbols(symbols);
                        float priceProductFromFile = decimalFormat.parse(productInfo[2]).floatValue();
                        int quantityProductFromFile = Integer.parseInt(productInfo[3]);
                        boolean isWholesaleProductFromFile = false;
                        if ((productInfo[4]).equals("+")) {
                            isWholesaleProductFromFile = true;
                        }
                        product = new Product(idProductFromLine,
                                descriptionProductFromFile,
                                priceProductFromFile,
                                quantityProductFromFile,
                                isWholesaleProductFromFile);
                    }
                }
            if (!isProductFound) {
                System.out.println("Product not found.");
               //new IndexOutOfBoundsException();
            }
        } catch (IOException | RuntimeException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }


    //    public String readFile(){
//        String fileData = "";
//        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
//            String lineFromFile;
//            while ((lineFromFile = reader.readLine()) != null) {
//                fileData = fileData + lineFromFile + "\r\n";
//            }
//        } catch (IOException | RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//        return fileData;
//    }
}
