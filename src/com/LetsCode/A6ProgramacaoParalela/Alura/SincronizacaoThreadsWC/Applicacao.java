package com.LetsCode.A6ProgramacaoParalela.Alura.SincronizacaoThreadsWC;

public class Applicacao {



    public static void main(String[] args) {

        Banheiro banheiro = new Banheiro();
        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Paulo");
        Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Maria");
        Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Ana");

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
    }


}
