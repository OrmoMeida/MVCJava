package control;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import model.Musica;
import pExceptions.MusicNotFoundException;

public class MusicaControl {
    private ArrayList<Musica> lstMusica;
    private static MusicaControl musicaControl;

    private MusicaControl() {
        this.lstMusica = new ArrayList<Musica>();
    }

    public static MusicaControl getInstance() {
        if (musicaControl == null)
            musicaControl = new MusicaControl();
        
        return musicaControl;
    }

    public void add(Musica e) {
        lstMusica.add(e);
    }

    public Musica find(String nome) throws MusicNotFoundException {
        for (Musica musica : lstMusica) {
            if (musica.getNome() == nome)
                return musica;
        }

        throw new MusicNotFoundException();
    }

    public void remove(String nome) throws MusicNotFoundException {
        lstMusica.remove(find(nome));
    }
}
