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

    private MusicaControl() throws SQLException {
        this.dao = MusicaDAO.getInstance();
        this.lstMusica = new ArrayList<Musica>();
        fetch();
    }

    public static MusicaControl getInstance() throws SQLException {
        if (musicaControl == null)
            musicaControl = new MusicaControl();

        return musicaControl;
    }

    public void add(Musica e) throws SQLException {
        dao.add(e);
        lstMusica.add(e);
    }

    public Musica find(String nome, String autor) throws MusicNotFoundException, SQLException {
        return findAll(nome, autor).get(0);
    }

    public ArrayList<Musica> findAll(String nome, String autor) throws MusicNotFoundException, SQLException {
        fetch();
        ArrayList<Musica> lMusicas = new ArrayList<Musica>();

        for (Musica musica : lstMusica) {
            if (musica.getAutor().toLowerCase().startsWith(autor.toLowerCase())
                    && musica.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                lMusicas.add(musica);
        }
    
        if (lMusicas.size() < 1)
            throw new MusicNotFoundException();

        return lMusicas;
    }

    public ArrayList<Musica> findByName(String nome) throws MusicNotFoundException, SQLException {
        fetch();
        ArrayList<Musica> lMusicas = new ArrayList<Musica>();

        for (Musica musica : lstMusica) {
            if (musica.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                lMusicas.add(musica);
        }

        if (lMusicas.size() > 0)
            return lMusicas;
        else
            throw new MusicNotFoundException();
    }

    public ArrayList<Musica> findByAuthor(String autor) throws MusicNotFoundException, SQLException {
        fetch();
        ArrayList<Musica> lMusicas = new ArrayList<Musica>();

        for (Musica musica : lstMusica) {
            if (musica.getAutor().toLowerCase().startsWith(autor.toLowerCase()))
                lMusicas.add(musica);
        }

        if (lMusicas.size() > 0)
            return lMusicas;
        else
            throw new MusicNotFoundException();
    }

    /*
    public Musica findPerf(String nome, String autor) throws MusicNotFoundException, SQLException {
        fetch();
        
        for (Musica musica : lstMusica) {
            if (musica.getAutor().equalsIgnoreCase(autor)
                    && musica.getNome().equalsIgnoreCase(nome))
                return musica;
        }

        throw new MusicNotFoundException();
    }
    */

    public void remove(String nome, String autor) throws MusicNotFoundException, SQLException {
        Musica musica = find(nome, autor);
        lstMusica.remove(musica);
        dao.remove(musica);
    }

    private void fetch() throws SQLException {
        try {
            this.lstMusica = dao.get();
        } catch (SQLException e) {
            throw new SQLException("Erro: Impossível receber valores do banco de dados.");
        }
    }

    public ArrayList<Musica> getList() {
        return lstMusica;
    }
}
