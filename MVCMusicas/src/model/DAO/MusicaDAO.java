package model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        PreparedStatement smt = connection.prepareStatement(
                "INSERT INTO JMusica(nome, autor, album, duracao, data_publicacao) values (?, ?, ?, ?, ?)");

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
        PreparedStatement smtSafe = connection.prepareStatement("SET SQL_SAFE_UPDATES = 0");
        smtSafe.execute();
        smtSafe.close();

        PreparedStatement smt = connection.prepareStatement("DELETE FROM JMusica WHERE nome=? AND autor=? LIMIT 1");

        smt.setString(1, nome);
        smt.setString(2, autor);

        smt.execute(); // setembro.
        smt.close();
    }

    public void remove(Musica e) throws SQLException {
        remove(e.getNome(), e.getAutor());
    }

    public ArrayList<Musica> select() throws SQLException {
        PreparedStatement smt = connection.prepareStatement("SELECT * FROM JMusica");
        ResultSet rs = smt.executeQuery();
        ArrayList<Musica> lMusicas = RSetToList(rs);
        smt.close();

        return lMusicas;
    }

    public ArrayList<Musica> selectByName(String name) throws SQLException {
        PreparedStatement smt = connection.prepareStatement("SELECT * FROM JMusica WHERE LOWER(nome) LIKE ?");
        smt.setString(1, name + "%");
        ResultSet rs = smt.executeQuery();
        ArrayList<Musica> lMusicas = RSetToList(rs);
        smt.close();

        return lMusicas;
    }

    public ArrayList<Musica> selectByAuthor(String author) throws SQLException {
        PreparedStatement smt = connection.prepareStatement("SELECT * FROM JMusica WHERE LOWER(autor) LIKE ?");
        smt.setString(1, author + "%");
        ResultSet rs = smt.executeQuery();
        ArrayList<Musica> lMusicas = RSetToList(rs);
        smt.close();

        return lMusicas;
    }

    public ArrayList<Musica> selectByAuthorANDName(String name, String author) throws SQLException {
        PreparedStatement smt = connection.prepareStatement("SELECT * FROM JMusica WHERE LOWER(nome) LIKE ? AND LOWER(autor) LIKE ?");
        smt.setString(1, name.toLowerCase() + "%");
        smt.setString(2, author.toLowerCase() + "%");
        ResultSet rs = smt.executeQuery();
        ArrayList<Musica> lMusicas = RSetToList(rs);
        
        smt.close();
        return lMusicas;
    }

    public static ArrayList<Musica> RSetToList(ResultSet rs) throws SQLException {
        ArrayList<Musica> lstMusicas = new ArrayList<Musica>();

        while (rs.next()) {
            String nome = rs.getString("nome");
            String autor = rs.getString("autor");
            String album = rs.getString("album");
            String duracao = rs.getString("duracao");
            String dataPb = rs.getString("data_publicacao");

            lstMusicas.add(new Musica(nome, album, autor, duracao, dataPb));
        }

        rs.close();
        return lstMusicas;
    }
}