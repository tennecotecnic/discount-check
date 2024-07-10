package ru.clevertec.check.io;

import ru.clevertec.check.dto.BasketOutputDto;
import ru.clevertec.check.dto.ProductItemDto;

import java.io.FileWriter;

public class CsvWriter implements  ResultWriter{

    public void writeResult(BasketOutputDto basketOutputDto) throws Exception{
        try(FileWriter fileWriter = new FileWriter("d:\\Projects\\check\\result.csv")){
            StringBuilder stringBuilder = new StringBuilder();
            for(ProductItemDto productItemDto: basketOutputDto.getProductItems()) {
                stringBuilder.append(productItemDto);
            }
            fileWriter.write(stringBuilder.toString());
            System.out.println(basketOutputDto);
        } catch(Exception e) {

        }
    }


    public void writeError(Exception exception) {

    }
}
