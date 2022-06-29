package com.LetsCode.Aula2Lambda.ExercicioListaTelefonica;

import com.LetsCode.Aula2Lambda.ExercicioEstacionamento.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;


public class ListaTelefonicaRepository implements IListaTelefonica {

    private static ListaTelefonicaRepository listaTelefonicaRepository;
    private ArrayList<Contato> listaTelefonica;

    private ListaTelefonicaRepository() {
        listaTelefonica = new ArrayList<>();

    }

    public static ListaTelefonicaRepository getInstance() {
        if (listaTelefonicaRepository == null) {
            listaTelefonicaRepository = new ListaTelefonicaRepository();
        }
        return listaTelefonicaRepository;
    }

    @Override
    public void gravarContato(Contato contato) {
        if (contato != null) {
            listaTelefonica.add(contato);
        }
    }

    @Override
    public void apagarContato(Contato contato) {
        listaTelefonica.remove(contato);
    }

    @Override
    public void consultarContato(String nome) {
        for (Contato contatoCadastrado : listaTelefonica) {
            if (contatoCadastrado.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contatoCadastrado);
            }

        }
    }

    @Override
    public void listar(Predicate<Contato> pesquisaContatos) {
        for (Contato contato : this.listaTelefonica){
            if(pesquisaContatos.test(contato)){
                System.out.println(contato);
            }
        }

    }

    @Override
    public void listarContatoPorLetraInicia(char letra) {
        for (Contato contato : this.listaTelefonica){
            if(contato.getNome().charAt(0) == letra){
                System.out.println(contato);
            }
        }
    }

    public ArrayList<Contato> getListaTelefonica() {
        listaTelefonica.sort((Contato c1, Contato c2) -> {
            return c1.getNome().compareTo(c2.getNome());
        });
        return listaTelefonica;
    }

    public void imprimirListaTelefonica(){
        listaTelefonica.sort(comparing(Contato::getNome));
        listaTelefonica.forEach(System.out::println);
    }


}

