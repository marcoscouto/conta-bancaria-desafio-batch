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

}

