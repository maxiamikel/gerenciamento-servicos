package com.maxi.gerenciamento.apiGerenciamento.domains.enums;

public enum Status {

    ABERTO(0, "ABERTo"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String status;
    private Status(Integer codigo, String status) {
        this.codigo = codigo;
        this.status = status;
    }
    public Integer getCodigo() {
        return codigo;
    }
    
    public String getStatus() {
        return status;
    }
    
    public static Status toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(Status s : Status.values()){
            if(codigo == s.getCodigo()){
                return s;
            }
        }

        throw new IllegalArgumentException("O status informado é invalido");
    }
    
}
