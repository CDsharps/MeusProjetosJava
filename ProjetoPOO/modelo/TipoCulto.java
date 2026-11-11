package modelo;

public enum TipoCulto {

    CULTO_DE_DOMINGO("Culto da família"),
    CULTO_DOS_VAROES("Culto dos varões"),
    CULTO_DAS_SENHORAS("Culto das senhoras"),
    CULTO_DOS_JOVENS("Culto dos jovens"),
    CULTO_DE_TERÇA("Estudo Bíblico"),
    CULTO_DE_QUINTA("Culto de Libertação"),
    CULTO_DE_SABADO("Culto de adolescentes");
    
    private String descriçao;
    
    TipoCulto(String descriçao) {

        this.descriçao = descriçao;
    }

    public String getDescriçao() {

        return descriçao;
    }
}