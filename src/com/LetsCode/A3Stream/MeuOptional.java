package com.LetsCode.A3Stream;

public class MeuOptional<T> {

    private T objeto;

    public MeuOptional(T objeto) {
        this.objeto = objeto;
    }

    public static <T>MeuOptional<T> from (T objeto) {
        return new MeuOptional<>(objeto);
    }

    @Override
    public String toString() {
        if (objeto != null) {
            return objeto.toString();
        }else
            return "";


        }
    }

