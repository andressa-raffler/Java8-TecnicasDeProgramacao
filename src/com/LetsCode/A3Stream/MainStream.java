package com.LetsCode.A3Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream {
        static List<Pessoa> pessoaList = new ArrayList<>();
    public static void main(String[] args) {
        pessoaList.add(new Pessoa("Joao", 18));
        pessoaList.add(new Pessoa("Maria", 20));
        pessoaList.add(new Pessoa("Isabela", 19));
        pessoaList.add(new Pessoa("Miguel", 38));


        streamXCollecions();
        exemplosStream();
        exemploOptional();
        inicializarStream();


    }

    private static void streamXCollecions() {
        System.out.println("----------Stream---------");
        pessoaList.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .forEach(System.out::println);

        System.out.println("----------Collections---------");
        pessoaList.sort((p1, p2)->p1.getIdade().compareTo(p2.getIdade()));
        for (Pessoa p : pessoaList){
            System.out.println(p);
        }

        System.out.println("----------Filtrando com Stream---------");
        pessoaList.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .forEach(System.out::println);
    }

    private static void exemplosStream() {
        boolean existePessoa = pessoaList.stream()
                .anyMatch(pessoa -> pessoa.getNome().equals("Isabela"));
        System.out.println(existePessoa);


        boolean todosMaioresDeIdade = pessoaList.stream()
                .allMatch(pessoa -> pessoa.getIdade() > 18);//VERIFICAR SE TODAS AS PESSOAS DA LISTA TEM +18
        System.out.println(todosMaioresDeIdade);


        List<String> listaDeNomes = pessoaList.stream()
                .filter(pessoa -> pessoa.getIdade() >=20 && pessoa.getIdade()<=40)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());
        //MAP mapeia a sua lista conforme vc pedir
        for (String nome:listaDeNomes)
            System.out.println(nome);
    }

    private static void exemploOptional() {
        //EXEMPLO OPTIONAL
        Optional<Pessoa> optionalPessoa = pesquisar("Lucas");
        optionalPessoa.ifPresent(System.out::println);
        MeuOptional<Pessoa> p1 = MeuOptional.from(new Pessoa("NomeOptional",10));
        MeuOptional<Pessoa> p2 = MeuOptional.from(null);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

    private static void inicializarStream() {
        Stream<Pessoa> pessoaStream1 = pessoaList.stream();
        Stream<Pessoa> pessoaStream2 = Stream.of(new Pessoa("Joao", 18));
        Stream<Pessoa> pessoaStream3 = Stream.empty();
        String[] nomes = new String[]{"Joao","Maria","Gui"};
        Stream<String> pessoaStream4 = Arrays.stream(nomes);
        IntStream pessoaStrea5 = new Random().ints(1,6);
    }

    private static Optional<Pessoa> pesquisar(String nome) {
        for(Pessoa pessoa: pessoaList){
            if(pessoa.getNome().equals(nome))
                return Optional.of(pessoa);
        }
        return  Optional.empty();
    }
}
