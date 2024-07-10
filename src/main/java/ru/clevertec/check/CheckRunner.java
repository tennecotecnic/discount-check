    package ru.clevertec.check;

import ru.clevertec.check.converter.Converter;
import ru.clevertec.check.dto.BasketOutputDto;
import ru.clevertec.check.dto.InputDto;
import ru.clevertec.check.exception.ExceptionCode;
import ru.clevertec.check.exception.MyException;
import ru.clevertec.check.io.CmdWriter;
import ru.clevertec.check.io.CsvWriter;
import ru.clevertec.check.io.ResultWriter;
import ru.clevertec.check.service.CalculationService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CheckRunner {
    private static Converter converter = new Converter();
    private static CalculationService calculationService = new CalculationService();
    private static List<ResultWriter> resultWriters = List.of(new CmdWriter(), new CsvWriter());

    public static void main(String[] args) {
        try {
            InputDto inputDto = converter.convertToDto(args);
            BasketOutputDto basketOutputDto = calculationService.process(inputDto);
            resultWriters.forEach(r-> {
                try {
                    r.writeResult(basketOutputDto);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (MyException e) {
            logError(e);

        } catch (Exception e){
            logError(new Exception(ExceptionCode.INTERNAL_SERVER_ERROR.getTitle()));
        }
    }

    private static void logError(Exception e){
//        System.out.println(e.getMessage();
        //write to file
    }
}