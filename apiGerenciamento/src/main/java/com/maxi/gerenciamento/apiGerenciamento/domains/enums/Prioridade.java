package com.maxi.gerenciamento.apiGerenciamento.domains.enums;

public enum Prioridade {
    
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");


    private Integer codigo;
    private String status;
    private Prioridade(Integer codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public String getStatus() {
        return status;
    }

    public static Prioridade toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(Prioridade p: Prioridade.values()){
            if(codigo == p.getCodigo()){
                return p;
            }
        }
        throw new IllegalArgumentException("A prioridade é inválida ou não existe no sistema");
    }
}
