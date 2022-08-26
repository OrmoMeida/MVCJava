package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Musica {
    private String nome;
    private String autor;
    private String album;
    private long duracao;
    private LocalDate dataPublicacao;
    public final static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final static Pattern dataCheck = Pattern.compile("\\d{2}-([01][1-9|0])-\\d{4}");

    public Musica (String nome, String album, String autor, long duracao, String dataPublicacao) {
        setNome(nome);
        setAutor(autor);
        setAlbum(album);
        setDuracao(duracao);
        setDataPublicacao(dataPublicacao);
    }

    public String getNome() {
    	return this.nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }


    public String getAlbum() {
    	return this.album;
    }
    public void setAlbum(String album) {
    	this.album = album;
    }


    public String getAutor() {
    	return this.autor;
    }
    public void setAutor(String autor) {
    	this.autor = autor;
    }


    public long getDuracao() {
    	return this.duracao;
    }
    public void setDuracao(long duracao) {
    	this.duracao = duracao;
    }


    public LocalDate getDataPublicacao() {
    	return this.dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
    	this.dataPublicacao = (LocalDate) dataFormat.parse(dataPublicacao);
    }
}
