package org.skypro.model.Exception;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super("Такой товар не существует");
    }
}
