package faculdade;

import java.io.Serializable;

public class Endereço implements Serializable {

    private String rua;
    private String bairro;
    private int numero;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereço [rua = " + rua + ", bairro = " + bairro + ", numero = " + numero + "]";
    }
}