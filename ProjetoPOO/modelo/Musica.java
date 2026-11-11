package modelo;

import excessoes.BpmInvalidoException;
import excessoes.TomInvalidoException;

public class Musica {

    private String nome;
    private String artista;
    private String tom;
    private int bpm;

    private static final String[] TONS_VALIDOS = { "C", "D", "E", "F", "G", "A", "B", "C#", "D#", "F#", "G#", "A#",
            "Db", "Eb", "Gb", "Ab", "Bb", "Cm", "Dm", "Em", "Fm", "Gm", "Am", "Bm", "C#m", "D#m", "F#m", "G#m", "A#m",
            "Dbm", "Ebm", "Gbm", "Abm", "Bbm" };

    public Musica(String nome, String artista, String tom, int bpm) throws TomInvalidoException, BpmInvalidoException {

        setNome(nome);
        setArtista(artista);
        setTom(tom);
        setBpm(bpm);
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {

            throw new IllegalArgumentException("Digite algo no campo do Nome!");
        }

        this.nome = nome;
    }

    public String getArtista() {

        return artista;
    }

    public void setArtista(String artista) {

        if (artista == null || artista.isBlank()) {

            throw new IllegalArgumentException("Digite algo no campo do Artista!");
        }

        this.artista = artista;
    }

    public String getTom() {

        return tom;
    }

    public void setTom(String tom) throws TomInvalidoException {

        if (tom == null || tom.isBlank()) {

            throw new TomInvalidoException("Digite algo no campo do tom!");
        }

        boolean tomValido = false;

        for (String t : TONS_VALIDOS) {

            if (t.equalsIgnoreCase(tom)) {

                tomValido = true;
                break;
            }
        }

        if (!tomValido) {

            throw new TomInvalidoException("Tom inválido: " + tom);
        }

        this.tom = tom;
    }

    public int getBpm() {

        return bpm;
    }

    public void setBpm(int bpm) throws BpmInvalidoException {

        if (bpm < 40 || bpm > 220) {

            throw new BpmInvalidoException("Bpm Inválido: " + bpm);
        }

        this.bpm = bpm;
    }
}