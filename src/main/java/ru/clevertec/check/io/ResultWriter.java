package ru.clevertec.check.io;

import ru.clevertec.check.dto.BasketOutputDto;

import java.io.IOException;

public interface ResultWriter {
    void writeResult(BasketOutputDto basketOutputDto) throws Exception;
    void writeError(Exception exception);
}
