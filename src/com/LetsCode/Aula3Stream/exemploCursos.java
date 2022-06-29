package com.LetsCode.Aula3Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class exemploCursos {
    public static void main(String[] args) {

        ArrayList<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.stream()
                .filter(c -> c.getAlunos() >= 50) //UTILIZAÇAO DO FILTER, INTERFACE FLUENTE
                .map(Curso::getAlunos)           //c -> c.getAlunos())
                .forEach(System.out::println);   //total -> System.out.println(total)

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
                                            //O map.ToInt me permite trabalhar com o Int resultado
        System.out.println(sum);

        Stream<String> nomes =
        cursos.stream()
                .map(Curso::getNome);
        nomes.forEach(System.out::println);

         cursos.stream()  //OPTIONAL é classe que ajuda a trabalhar com null
                .filter(c -> c.getAlunos() >= 100 )
                .findAny()
                .ifPresent(c-> System.out.println(c.getNome())); //Imprime se existir

     //   Curso curso = cursoOptional.orElse(null); //Devolve o curso do stream acima ou nulll

        List<Curso> listaStream = cursos.stream()
                .filter(c -> c.getAlunos() >= 50)
                .collect(Collectors.toList()); //Converte o stream em uma lista

        //Calcule a quantidade média de alunos de todos os seus cursos utilizando a API de Stream.

       OptionalDouble mediaAlunos = cursos.stream()
                .mapToDouble(Curso::getAlunos)
                .average();
        System.out.println(mediaAlunos.getAsDouble());

    }
}
