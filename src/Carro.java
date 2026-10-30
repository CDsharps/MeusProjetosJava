public class Carro {

    private String tipo;
    private String cor;
    private String placa;
    private int numPortas;
    private Pessoa dono;

    public Carro() {
    }

    public Carro(String tipo, String cor, String placa, int numPortas) {

        this.tipo = tipo;
        this.cor = cor;
        this.placa = placa;
        this.numPortas = numPortas;
    }

    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {

        if (tipo != null && !tipo.isBlank()) {

            this.tipo = tipo;
        }
    }

    public String getCor() {

        return cor;
    }

    public void setCor(String cor) {

        if (cor != null && !cor.isBlank()) {

            this.cor = cor;
        }
    }

    public String getPlaca() {

        return placa;
    }

    public void setPlaca(String placa) {

        if (placa != null && !placa.isBlank()) {

            this.placa = placa;
        }
    }

    public int getNumPortas() {

        return numPortas;
    }

    public void setNumPortas(int numPortas) {

        if (numPortas >= 2 && numPortas <= 5) {

            this.numPortas = numPortas;
        }
    }

    public void show() {

        System.out.println("Tipo: " + tipo + "\nCor: " + cor + "\nPlaca: " + placa + "\nQuanidade de portas: " + numPortas + "\nDono: " + dono);
    }
}