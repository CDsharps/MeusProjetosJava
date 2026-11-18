package persistencia;

import modelo.Musica;

import java.util.List;

import excessoes.BpmInvalidoException;
import excessoes.TomInvalidoException;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class MusicaDAO {

    public void salvarMusica(Musica musica) throws IOException {

        File arquivo = Arquivo.getArquivoRepertorio();

        int proximoId = gerarProximoId(arquivo);

        try (FileWriter fw = new FileWriter(arquivo, true);
                PrintWriter pw = new PrintWriter(fw)) {

            String delimitada = proximoId + ";" +
                    musica.getNome() + ";" +
                    musica.getArtista() + ";" +
                    musica.getTom() + ";" +
                    musica.getBpm() + ";" +
                    musica.getUrlCifra();

            pw.println(delimitada);
            System.out.println("Música salva com sucesso!");

        } catch (IOException e) {

            System.out.println("[ERRO] Não foi possível salvar a música: " + e.getMessage());
        }
    }

    public void excluirMusica(int ID) throws TomInvalidoException, BpmInvalidoException, IOException {

        List<Musica> musicas = listarMusicas();

        if (ID > 0 && ID <= musicas.size()) {

            musicas.remove(ID - 1);
            reescreverArquivo(musicas);
            System.out.println("Música excluída com sucesso!");
        } else {

            System.out.println("[ERRO] ID inválido ou não encontrado!");
        }
    }

    private List<Musica> listarMusicas() throws TomInvalidoException, BpmInvalidoException, IOException {

        List<Musica> musicas = new ArrayList<>();
        File arquivo = Arquivo.getArquivoRepertorio();

        if (!arquivo.exists()) {

            return musicas;
        }

        try (BufferedReader leia = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = leia.readLine()) != null) {

                if (linha.isBlank()) {

                    continue;
                }

                String[] partes = linha.split(";");

                if (partes.length >= 6) {

                    String nome = partes[1];
                    String artista = partes[2];
                    String tom = partes[3];
                    int bpm = Integer.parseInt(partes[4]);
                    String url = partes[5];

                    Musica musica = new Musica(nome, artista, tom, bpm, url);

                    musicas.add(musica);
                }
            }
        }

        return musicas;
    }

    public void atualizarMusicaParcial(int IdAlvo, String novoNome, String novoArtista, String novoTom, int novoBpm,
            String novoURL)
            throws TomInvalidoException, BpmInvalidoException, IOException {

        List<Musica> musicas = listarMusicas();

        if (IdAlvo > 0 && IdAlvo <= musicas.size()) {

            Musica musica = musicas.get(IdAlvo - 1);

            if (novoNome != null & !novoNome.isBlank())
                musica.setNome(novoNome);
            if (novoArtista != null && !novoArtista.isBlank())
                musica.setArtista(novoArtista);
            if (novoTom != null && !novoTom.isBlank())
                musica.setTom(novoTom);
            if (novoBpm > 0)
                musica.setBpm(novoBpm);
            if (novoURL != null && !novoURL.isBlank())
                musica.setUrlCifra(novoURL);
        }
    }

    private void reescreverArquivo(List<Musica> musicas) throws IOException {

        File arquivo = Arquivo.getArquivoRepertorio();

        try (FileWriter fw = new FileWriter(arquivo, false);
                PrintWriter pw = new PrintWriter(fw)) {

            int novoID = 1;

            for (Musica nova : musicas) {

                String delimitada = novoID + ";" +
                        nova.getNome() + ";" +
                        nova.getArtista() + ";" +
                        nova.getTom() + ";" +
                        nova.getBpm() + ";" +
                        nova.getUrlCifra();

                pw.println(delimitada);
                novoID++;
            }
        }
    }

    private int gerarProximoId(File arquivo) throws IOException {

        if (!arquivo.exists()) {

            return 1;
        }

        int contador = 0;

        try (BufferedReader leia = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = leia.readLine()) != null) {

                if (linha.isBlank()) {

                    continue;
                }

                contador++;
            }
        }

        return contador + 1;
    }
}