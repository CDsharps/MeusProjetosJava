package persistencia;

import java.io.File;

public class Arquivo {

    public static File getPastaPrincipal() {

        File pasta = new File(System.getenv("USERPROFILE"), "Louvor");
        
        if(!pasta.exists()) {

            pasta.mkdir();
        }

        return pasta;
    }

    public static File getArquivoRepertorio() {

        return new File(getPastaPrincipal(), "Repertorio.txt");

    }

    public static File getArquivoEscala() {

        return new File(getPastaPrincipal(), "Escalas.txt");

    }

    public static File getArquivoVoluntarios() {

        return new File(getPastaPrincipal(), "Voluntarios.txt");

    }
}