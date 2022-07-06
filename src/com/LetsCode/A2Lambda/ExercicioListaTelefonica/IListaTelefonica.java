package com.LetsCode.A2Lambda.ExercicioListaTelefonica;

import java.util.function.Predicate;

public interface IListaTelefonica {

    void gravarContato(Contato contato);
    void apagarContato(Contato contato);
    void consultarContato(String nome);
    void listar (Predicate<Contato> pesquisaContatos);
    void listarContatoPorLetraInicia(char letra);

}
