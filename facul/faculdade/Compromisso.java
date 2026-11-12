package faculdade;

import java.io.Serializable;
import java.util.List;

public class Compromisso implements Serializable {

    private String descricao;
    private Data data;
    private int hora;
    private int minuto;
    private List<Contato> contatos;

    public void adContato(Contato contato) {

        if (contato != null && !contatos.contains(contato)) {

            contatos.add(contato);
        }
    }

    public Contato buscarContato(int i) {

        return contatos.get(i);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return "Compromisso [descricao = " + descricao + ", data = " + data + ", hora = " + hora + ":" + minuto
                + ", contatos = " + contatos + "]";
    }
}
