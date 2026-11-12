package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Arquivos {
    
    public static String raiz = ".\\agenda\\";
    public static String raizContatos = raiz + "contatos\\";
    public static String raizCompromissos = raiz + "compromissos\\";
    public static String raizIds = raiz + "ids\\";
    public static String idContato = raizIds + "idcontatos.txt";
    public static String idCompromisso = raizIds + "idcompromisso.txt";

    public static void resetarInicializarAgenda() {

        File dir = new File(raiz);
        if(dir.isDirectory()) {

            excluirDiretorio(raiz);
        }

        dir = new File(raiz);
        dir.mkdir();

        dir = new File(raizContatos);
        dir.mkdir();

        dir = new File(raizCompromissos);
        dir.mkdir();

        dir = new File(raizIds);
        dir.mkdir();

        gravarId("contatos", 0);
        gravarId("compromissos", 0);
    }

    private static void gravarId(String nome, int i) {
        
        try {

            PrintWriter print = new PrintWriter(new FileWriter(raizIds + "id" + nome + ".txt"));
            print.print(i);
        } catch (IOException e) {

            System.out.println("[ERRO] " + e.getMessage() + " - Não foi possível criar o arquivo!");
        }
    }

    public static int lerId(String nome) {

        File arquivo = new File(raizIds + "id" + nome + ".txt");
        Scanner sc;

        try {

            sc = new Scanner(arquivo);
            return sc.nextInt();
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
        return -1;
    }

    public static boolean excluirDiretorio(String nomeDir) {
        File dir = new File(nomeDir);
        String men = "";
        if (dir.isDirectory()) {
            if (dir.delete()) {
                men = dir.getName() + "Excluído com sucesso!";
            } else {
                if (excluirFilhos(dir)) {
                    men = dir.getName() + " - Excluido com Sucesso!";
                } else {
                    men = "Falha na exclusão de " + dir.getName();
                    return false;
                }
            }
            System.out.println(men);
        }

        return true;
    }

    private static boolean excluirFilhos(File dir) {
        if (dir.isDirectory()) {
            String[] arquivos = dir.list();
            for (int i = 0; i < arquivos.length; i++) {
                boolean sucesso = excluirFilhos(new File(dir, arquivos[i]));
                if (sucesso) {
                    System.out.println("Excluído: " + arquivos[i]);
                } else {
                    System.out.println("Não pode ser excluído:" + arquivos[i]);
                    return false;
                }
            }
        }
        return dir.delete();
    }
}