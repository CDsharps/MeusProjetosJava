package servico;

import java.util.List;
import excessoes.MusicaJaCadastradaException;
import modelo.Musica;
import java.util.ArrayList;

public class Repertorio {

    private List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica novaMusica) throws MusicaJaCadastradaException {

        if (musicaJaExiste(novaMusica.getNome(), novaMusica.getArtista())) {

            throw new MusicaJaCadastradaException("A música '" + novaMusica.getNome() + "', de '"
                    + novaMusica.getArtista() + "' já existe no repertório!");
        }

        musicas.add(novaMusica);
    }

    public boolean removerMusica(Musica musica) {

        for (int i = 0; i < musicas.size(); i++) {

            Musica m = musicas.get(i);

            if (m.getNome().equalsIgnoreCase(musica.getNome())
                    && m.getArtista().equalsIgnoreCase(musica.getArtista())) {

                musicas.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean musicaJaExiste(String nomeBuscado, String artistaBuscado) {

        for (int i = 0; i < musicas.size(); i++) {

            Musica m = musicas.get(i);

            if (m.getNome().equalsIgnoreCase(nomeBuscado) && m.getArtista().equalsIgnoreCase(artistaBuscado)) {

                return true;
            }
        }

        return false;
    }

    public List<Musica> getMusicas() {

        return musicas;
    }
}