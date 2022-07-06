package com.LetsCode.A2Lambda.ExercicioListaTelefonica;

import java.util.function.Predicate;

import static com.LetsCode.A2Lambda.ExercicioListaTelefonica.ListaTelefonicaApplication.listaTelefonica;

public interface IListarContatosPorLetraInicial {
    default void listarContatosPorLetra(Predicate<Boolean> listarContatos, char letra) {
        for (Contato contato : listaTelefonica) {
            if (listarContatos.test(contato.getNome().charAt(0) == letra)) {
                System.out.println(contato);
            }
        }

    }
}
