package model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import connection.ConnectionManager;
import model.Musica;

public class MusicaDAO {
    private Connection connection;
    private static MusicaDAO musicaDAO;

    private MusicaDAO(Connection connection) {
        this.connection = connection;
    }

    private MusicaDAO() {
        this(ConnectionManager.getConnection());
    }

    public static MusicaDAO getInstance() {
        if (musicaDAO == null)
            musicaDAO = new MusicaDAO();

        return musicaDAO;
    }

    public void add(Musica e) throws SQLException {
        java.sql.PreparedStatement smt = connection.prepareStatement("INSERT INTO JMusica(nome, autor, album, duracao, data_publicacao) values (?, ?, ?, ?, ?)");

        smt.setString(1, e.getNome());
        smt.setString(2, e.getAutor());
        smt.setString(3, e.getAlbum());
        smt.setString(4, e.getDuracao());
        smt.setString(5, e.getDataPublicacao());
        // Preciso achar um jeito de passar essa data, urgentemente.

        smt.execute();
        smt.close();
    }

    public void remove(String nome, String autor) throws SQLException, IllegalArgumentException {
        PreparedStatement smt = connection.prepareStatement("DELETE FROM JMusica WHERE nome=? AND autor=?");
        
        smt.setString(1, nome);
        smt.setString(2, autor);

        boolean res = smt.execute();
        smt.close();

        if (!res)
            throw new IllegalArgumentException("Música não encontrada no banco de dados.");
    }
}