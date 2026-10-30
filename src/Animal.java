public class Animal {

    private String nome;
    private String raça;
    private int cansaço;
    private int fome;
    private int idade;

    public Animal(String nome, String raça, int cansaço, int fome, int idade){

        this.nome = nome;
        this.raça = raça;
        this.cansaço = cansaço;
        this.fome = fome;
        this.idade = idade;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        if (nome != null && !nome.isBlank()) {

            this.nome = nome;
        }
    }

    public String getRaça() {

        return raça;
    }

    public void setRaça(String raça) {

        if (raça != null && !raça.isBlank()) {

            this.raça = raça;
        }
    }

    public int getCansaço() {

        return cansaço;
    }

    public void setCansaço(int cansaço) {

        this.cansaço = cansaço;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {

        if (idade > 1 && idade < 100) {

            this.idade = idade;
        }
    }

    public void comer(){

        if(this.fome > 0){

            this.fome--;
        }
    }

    public void show() {

        System.out.println("Nome: " + nome + "\nRaça: " + raça + "\nCansaço: " + cansaço + "\nFome: " + fome + "\nIdade: " + idade);
    }
}