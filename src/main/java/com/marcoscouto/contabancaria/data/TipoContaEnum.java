package com.marcoscouto.contabancaria.data;

import java.math.BigDecimal;

public enum TipoContaEnum {

    PRATA {
        @Override
        public BigDecimal getLimite() {
            return new BigDecimal("500.00");
        }
    },
    OURO {
        @Override
        public BigDecimal getLimite() {
            return new BigDecimal("1000.00");
        }
    },
    PLATINA {
        @Override
        public BigDecimal getLimite() {
            return new BigDecimal("2500.00");
        }
    },
    DIAMANTE {
        @Override
        public BigDecimal getLimite() {
            return new BigDecimal("5000.00");
        }
    };

    abstract BigDecimal getLimite();

    public static TipoContaEnum getTipoConta(Double faixaSalarial){
        if (faixaSalarial <= 3000)
            return PRATA;
        if (faixaSalarial > 3000 && faixaSalarial <= 5000)
            return OURO;
        if (faixaSalarial > 5000 && faixaSalarial <= 10000)
            return PLATINA;
        if (faixaSalarial > 10000)
            return DIAMANTE;
        return null;
    }

}

