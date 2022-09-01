package model;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Musica {
    private String nome;
    private String autor;
    private String album;
    private String duracao;
    private String dataPublicacao;
    public final static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final static Pattern dataCheck     = Pattern.compile("\\d{2}-([01][1-9|0])-\\d{4}");
    public final static Pattern durationCheck = Pattern.compile("\\d{2}:\\d{2}");

    public Musica (String nome, String album, String autor, String duracao, String dataPublicacao) {
        setNome(nome);
        setAutor(autor);
        setAlbum(album);
        setDuracao(duracao);
        setDataPublicacao(dataPublicacao); 
    }

    public static String isEmpty(String s) throws IllegalArgumentException {
        s = s.trim(); // "  oi    " => "oi"
        if (s.isEmpty())
            throw new IllegalArgumentException("O campo não pode estar vazio.");
        
        return s;
    }

    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) throws IllegalArgumentException {
    	this.nome = isEmpty(nome);
    }


    public String getAlbum() {
    	return this.album;
    }
    public void setAlbum(String album) throws IllegalArgumentException {
    	this.album = isEmpty(album);
    }


    public String getAutor() {
    	return this.autor;
    }
    public void setAutor(String autor) throws IllegalArgumentException {
        this.autor = isEmpty(autor);
    }


    public String getDuracao() {
    	return this.duracao;
    }
    public void setDuracao(String duracao) throws IllegalArgumentException {
        duracao = isEmpty(duracao);

        if (!durationCheck.matcher(duracao).matches())
            throw new IllegalArgumentException("Formato de duração incorreto: Deve estar como MM:SS");

        this.duracao = duracao;
    }


    public String getDataPublicacao() {
    	return this.dataPublicacao;
    }
    public void setDataPublicacao(String dataPublicacao) throws IllegalArgumentException {
        dataPublicacao = isEmpty(dataPublicacao);
        if (!dataCheck.matcher(dataPublicacao).matches())
            throw new IllegalArgumentException("Formato de data incorreto: Deve estar como dd/MM/AAAA");

    	this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Música:  " + this.getNome()
                + "\t\nAutor:  " + this.getAutor()
                + "\t\nÁlbum:  " + this.getAlbum()
                + "\t\nDuração:  " + this.getDuracao()
                + "\t\nPublicação:  " + this.getDataPublicacao();
    }
}
