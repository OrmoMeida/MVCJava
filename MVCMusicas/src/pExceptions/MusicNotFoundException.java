package pExceptions;

import java.util.NoSuchElementException;

public class MusicNotFoundException extends NoSuchElementException {
    public static final String NotFoundByName   = "Nome de música não encontrado na busca.";
    public static final String NotFoundByAuthor = "Autor não encontrado na busca.";
    public static final String NotFound         = "Música não encontrada na busca.";
    public static final String EmptySearchSet   = "Nenhuma música encontrada na busca."; 

    public MusicNotFoundException() {
        super(NotFound);
    }

    public MusicNotFoundException(String s) {
        super(s);
    }
}
