package com.LetsCode.A6ProgramacaoParalela.Alura.SincronizacaoLista;

import java.util.List;
import java.util.Vector;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

      //  List<String>lista = new ArrayList<>();
      //  List <String> lista = Collections.synchronizedList(new ArrayList<String>()); //Maneira de sincronizar um arraylist
        List<String>lista = new Vector<String>(); //Vector é ThreadSafe, ou seja, sincronizado, nao da errro

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();

        }

        Thread.sleep(2000);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + " - " + lista.get(i));
        }
    }

}
