package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Musica;
import model.DAO.MusicaDAO;
import pExceptions.MusicNotFoundException;

public class MusicaControl {
    private final MusicaDAO dao;
    private static MusicaControl musicaControl;

    private MusicaControl() throws SQLException {
        this.dao = MusicaDAO.getInstance();
    }

    public static MusicaControl getInstance() throws SQLException {
        if (musicaControl == null)
            musicaControl = new MusicaControl();

        return musicaControl;
    }

    public void add(Musica e) throws SQLException {
        dao.add(e);
    }

    public Musica find(String nome, String autor) throws MusicNotFoundException, SQLException {
        return findAll(nome, autor).get(0);
    }

    public ArrayList<Musica> findAll(String nome, String autor) throws MusicNotFoundException, SQLException {
        ArrayList<Musica> lMusicas = dao.selectByAuthorANDName(nome, autor);

        /*
        for (Musica musica : lstMusica) {
            if (musica.getAutor().toLowerCase().startsWith(autor.toLowerCase())
            && musica.getNome().toLowerCase().startsWith(nome.toLowerCase()))
            lMusicas.add(musica);
        }
        */
        
        if (lMusicas.size() < 1)
            throw new MusicNotFoundException(MusicNotFoundException.NotFound);

        return lMusicas;
    }

    public ArrayList<Musica> findByName(String nome) throws MusicNotFoundException, SQLException {
        ArrayList<Musica> lMusicas = dao.selectByName(nome);

        /*
        for (Musica musica : lstMusica) {
            if (musica.getNome().toLowerCase().startsWith(nome.toLowerCase()))
                lMusicas.add(musica);
        }
        */
        
        if (lMusicas.size() > 0)
            return lMusicas;
        else
            throw new MusicNotFoundException(MusicNotFoundException.NotFoundByName);
        }
        
    public ArrayList<Musica> findByAuthor(String autor) throws MusicNotFoundException, SQLException {
        ArrayList<Musica> lMusicas = dao.selectByAuthor(autor);
        
        /*
        for (Musica musica : lstMusica) {
            if (musica.getAutor().toLowerCase().startsWith(autor.toLowerCase()))
                lMusicas.add(musica);
        }
        */

        if (lMusicas.size() > 0)
            return lMusicas;
        else
            throw new MusicNotFoundException(MusicNotFoundException.NotFoundByAuthor);
    }

    /*
    public Musica findPerf(String nome, String autor) throws MusicNotFoundException, SQLException {
        fetch();

        for (Musica musica : lstMusica) {
            if (musica.getAutor().equalsIgnoreCase(autor)
                    && musica.getNome().equalsIgnoreCase(nome))
                return musica;
        }

        throw new MusicNotFoundException(MusicNotFoundException.NotFound);
    }
    */

    public void remove(String nome, String autor) throws MusicNotFoundException, SQLException {
        remove(find(nome, autor));
    }

    public void remove(Musica e) throws MusicNotFoundException, SQLException {
        dao.remove(e);
    }

    public ArrayList<Musica> getList() throws SQLException {
        return dao.select();
    }
}
