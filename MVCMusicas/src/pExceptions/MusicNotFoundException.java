package pExceptions;

import java.util.NoSuchElementException;

public class MusicNotFoundException extends NoSuchElementException {
    public MusicNotFoundException() {
        super("Nome de música não encontrado na pesquisa.");
    }

    public MusicNotFoundException(String s) {
        super(s);
    }
}
