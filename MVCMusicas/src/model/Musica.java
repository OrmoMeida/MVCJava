package model;

public class Musica {
    private String nome;
    private String autor;
    private String album;
    private String duracao;
    private String dataPublicacao;

    public Musica(String nome, String album, String autor, String duracao, String dataPublicacao) {
        setNome(nome);
        setAutor(autor);
        setAlbum(album);
        setDuracao(duracao);
        setDataPublicacao(dataPublicacao);
    }

    public static String isEmpty(String s) throws IllegalArgumentException {
        s = s.trim(); // " oi " => "oi"
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

        duracao = duracao.replaceAll("^\\d:\\d{1,2}$", "0" + duracao).replaceAll("^\\d{2}:\\d{1}$", duracao + "0");

        if (!duracao.matches("\\d{2}:\\d{2}"))
            throw new IllegalArgumentException("Formato de duração incorreto: Deve estar como MM:SS");

        this.duracao = duracao;
    }

    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) throws IllegalArgumentException {
        dataPublicacao = isEmpty(dataPublicacao);
        dataPublicacao = dataPublicacao.replace('/', '-');
        if (!dataPublicacao.matches("\\d{2}-\\d{2}-\\d{4}"))
            throw new IllegalArgumentException("Formato de data incorreto: Deve estar como dd-MM-AAAA");

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

    public Object[] toObjects() {
        return new Object[] { getNome(), getAutor(), getAlbum(), getDuracao(), getDataPublicacao() };
    }
}
