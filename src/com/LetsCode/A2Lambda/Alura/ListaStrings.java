package com.LetsCode.A2Lambda.Alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class ListaStrings {
    public void executar() {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");
        palavras.sort(new ComparatorLenghtString());
        palavras.forEach(new ConsumerString());
    }



    public class ConsumerString implements Consumer<String>{

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

    public class ComparatorLenghtString implements Comparator<String>{

        @Override
        public int compare(String s1, String s2) {
            if(s1.length() < s2.length())
                return -1;
            if(s1.length() > s2.length())
                return 1;
            return 0;
        }
    }
}
