package com.LetsCode.Aula2Lambda.ExercicioListaTelefonica;

import com.LetsCode.Aula2Lambda.ExercicioEstacionamento.Veiculo;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface IListaTelefonica {

    void gravarContato(Contato contato);
    void apagarContato(Contato contato);
    void consultarContato(String nome);
    void listar (Predicate<Contato> pesquisaContatos);
    void listarContatoPorLetraInicia(char letra);

}
