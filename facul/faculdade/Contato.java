package faculdade;

import java.io.Serializable;
import java.util.List;

public class Contato implements Serializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private List<Endereço> endereços;

    public void adEndereço(Endereço endereco) {

        if (endereco != null && !endereços.contains(endereco)) {
            endereços.add(endereco);
        }
    }

    public Endereço buscarEndereço(int i) {

        return endereços.get(i);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereço> getEndereços() {
        return endereços;
    }

    public void setEndereços(List<Endereço> endereços) {
        this.endereços = endereços;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereços="
                + endereços + "]";
    }
}