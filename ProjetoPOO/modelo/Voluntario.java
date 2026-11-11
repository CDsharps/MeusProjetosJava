package modelo;

public class Voluntario {

    private String nome;
    private CargoLouvor funçao;
    private String telefone;

    public Voluntario(String nome, CargoLouvor funçao, String telefone) {

        setNome(nome);
        setFunçao(funçao);
        setTelefone(telefone);
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {

            throw new IllegalArgumentException("Digite algo no campo do nome!");
        }

        this.nome = nome;
    }

    public CargoLouvor getFunçao() {

        return funçao;
    }

    public void setFunçao(CargoLouvor funçao) {

        if (funçao == null) {

            throw new IllegalArgumentException("Digite algo no campo do nome!");
        }

        this.funçao = funçao;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        if (telefone == null || telefone.isBlank()) {

            throw new IllegalArgumentException("Digite algo no campo do telefone!");
        }

        String numero = telefone.replaceAll("\\D", "");

        if(numero.length() != 11) {

            throw new IllegalArgumentException("Telefone Inválido! Deve conter exatamente 11 dígitos!");
        }

        this.telefone = telefone;
    }
}