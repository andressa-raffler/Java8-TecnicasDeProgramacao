package com.LetsCode.A2Lambda.Alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ListaStringsLambda {
    public void executar() {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        //LAMBDA usando propriedade do Integer
        palavras.sort((s1, s2) -> Integer.compare(s1.length(),s2.length()));
         //OU fACTORY DENTRO DA INTERFACE COMPARATOR, Factory de Comparators
        palavras.sort(Comparator.comparing(palavra -> palavra.length()));
        palavras.sort(Comparator.comparing(String::length)); // FORMA MAIS RESUMIDA DA LINHA ACIMA, MÉTODO REFERENCE

        //EQUIVALE AS TRES LINHAS ABAIXO:
        Function<String, Integer> funcao = palavra -> palavra.length(); //FUNCAO Function do Java Util
        Comparator<String> comparador = Comparator.comparing(funcao);
        palavras.sort(comparador);


        palavras.forEach(palavra -> System.out.println(palavra));
        palavras.forEach(System.out::println); //Method Reference

    }
}


