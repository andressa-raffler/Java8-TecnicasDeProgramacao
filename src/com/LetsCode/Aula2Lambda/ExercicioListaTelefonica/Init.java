package com.LetsCode.Aula2Lambda.ExercicioListaTelefonica;

import java.time.LocalDate;

public class Init {
    public static void executar(){


        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Andressa",4188586589L, LocalDate.of(1994,7,16)));
        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Lucas",1189423456L, LocalDate.of(1990,3,30)));
        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Pedro",21965840394L, LocalDate.of(2002,7,30)));
        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Beatriz",1188884356L, LocalDate.of(1970,7,10)));
        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Pedro",45965840394L, LocalDate.of(1985,9,11)));
        ListaTelefonicaRepository.getInstance().gravarContato(new Contato("Pedro",63965840394L, LocalDate.of(1992,9,23)));



    }

}
