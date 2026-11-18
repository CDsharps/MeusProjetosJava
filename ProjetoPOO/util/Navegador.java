package util;

import java.awt.Desktop;
import java.net.URI;

public class Navegador {

    public static void abrirLink(String url) {

        try {

            if(Desktop.isDesktopSupported()) {

                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } else {
                 
                System.out.println("O sistema não suporta a abertura automática de links.");
            }
        } catch (Exception e) {

        System.out.println("Erro ao abrir o navegador: " + e.getMessage());
        }
    }
}