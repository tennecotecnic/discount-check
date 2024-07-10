package ru.clevertec.check.exception;

public enum ExceptionCode {
    BAD_REQUEST("ERROR\r\nBAD REQUEST"),
    NOT_ENOUGH_MONEY("ERROR\r\nNOT ENOUGH MONEY"),
    INTERNAL_SERVER_ERROR("ERROR\r\nINTERNAL SERVER ERROR");
    private String title;

    ExceptionCode(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
