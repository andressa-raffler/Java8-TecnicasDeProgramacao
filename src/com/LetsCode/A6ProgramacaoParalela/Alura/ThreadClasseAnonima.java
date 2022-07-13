package com.LetsCode.A6ProgramacaoParalela.Alura;

public class ThreadClasseAnonima {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("açao que será executada na thread");
            }
        }).start(); //.start para fazer rodar
    }
}

