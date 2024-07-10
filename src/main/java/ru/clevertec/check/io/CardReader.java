package ru.clevertec.check.io;

import ru.clevertec.check.exception.ExceptionCode;
import ru.clevertec.check.exception.MyException;
import ru.clevertec.check.model.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardReader {

    private final String FINAL_NAME = "c:\\Users\\Titanium\\Desktop\\discountCards.csv";


    public Card findByNumber(int number){
        Card card = null;
        boolean isCardFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FINAL_NAME))) {
            String lineFromFile = reader.readLine();
            while(!isCardFound && (lineFromFile = reader.readLine()) != null) {
                String [] cardInfo = lineFromFile.split(";");
                int numberCardFromLine = Integer.parseInt(cardInfo[1]);
                if (number == numberCardFromLine) {
                    isCardFound = true;
                    int discountAmount = Integer.parseInt(cardInfo[2]);
                    card = new Card(numberCardFromLine, discountAmount);
                }
            }
            if (!isCardFound) {
                throw new MyException(ExceptionCode.BAD_REQUEST.name());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return card;
    }
}
