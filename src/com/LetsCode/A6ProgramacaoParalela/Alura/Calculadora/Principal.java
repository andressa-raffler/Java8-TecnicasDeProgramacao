package com.LetsCode.A6ProgramacaoParalela.Alura.Calculadora;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Isso é o thread main");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
