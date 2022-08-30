package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Musica;
import model.DAO.MusicaDAO;
import pExceptions.MusicNotFoundException;

public class MusicaControl {
    private ArrayList<Musica> lstMusica;
    private final MusicaDAO dao;
    private static MusicaControl musicaControl;

    private MusicaControl() {
        this.lstMusica = new ArrayList<Musica>();
        this.dao = MusicaDAO.getInstance();
    }

    public static MusicaControl getInstance() {
        if (musicaControl == null)
            musicaControl = new MusicaControl();
        
        return musicaControl;
    }

    public void add(Musica e) throws SQLException {
        dao.add(e);
        lstMusica.add(e);
    }

    public Musica find(String nome, String autor) throws MusicNotFoundException {
        ArrayList<Musica> musicasAutor = new ArrayList<Musica>();

        for (Musica musica : lstMusica) {
            if (musica.getAutor().equals(nome))
                musicasAutor.add(musica);
        }

        for (Musica musica : musicasAutor) {
            if (musica.getNome().equals(nome))
                return musica;
        }

        throw new MusicNotFoundException();
    }

    public void remove(String nome, String autor) throws MusicNotFoundException, SQLException {
        lstMusica.remove(find(nome, autor));
        dao.remove(nome, autor);
    }
}
