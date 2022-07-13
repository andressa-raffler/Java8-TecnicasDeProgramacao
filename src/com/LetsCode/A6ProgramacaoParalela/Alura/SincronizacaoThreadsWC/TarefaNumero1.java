package com.LetsCode.A6ProgramacaoParalela.Alura.SincronizacaoThreadsWC;

public class TarefaNumero1 implements Runnable {
    private Banheiro banheiro;

    public TarefaNumero1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero1();
    }
}
