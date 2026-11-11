package modelo;

public enum CargoLouvor {

    VOCALISTA("Vocal / Backing Vocal"),
    TECLADISTA("Tecladista / Pianista"),
    VIOLONISTA("Violonista"),
    GUITARRISTA("Guitarrista"),
    BATERISTA("Baterista"),
    BAIXISTA("Baixista"),
    MULTIMIDIA("Projeção e Multimídia");

    private String descriçao;

    private static final CargoLouvor[] OPÇOES = values();

    CargoLouvor(String descriçao) {

        this.descriçao = descriçao;
    }

    public String getDescriçao() {

        return descriçao;
    }
}