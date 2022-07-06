package com.LetsCode.A2Lambda.ExercicioListaTelefonica;


import java.util.ArrayList;
import java.util.Scanner;



/*  - Listar contatos por idade, ex: Buscar contato com mais de 30 anos
    - Listar contatos por letra, ex: Buscar letra A e mostrar quem começa com A
    - Listar contatos por DDD, exemplo, buscar telefone que começa com 41
*/
public class ListaTelefonicaApplication  {
    static ArrayList<Contato> listaTelefonica;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Init.executar();

        listaTelefonica = ListaTelefonicaRepository.getInstance().getListaTelefonica();
        ListaTelefonicaRepository.getInstance().imprimirListaTelefonica();
        ListaTelefonicaRepository.getInstance().listar(contato -> contato.getIdade() >= 30);
        ListaTelefonicaRepository.getInstance().listar(contato -> contato.getNome().charAt(0) == 'A');
        ListaTelefonicaRepository.getInstance().listar(contato -> contato.getTelefone() == 41);


        listaTelefonica.stream()
                .filter(contato -> contato.getNome().charAt(0)=='B')
                .forEach(System.out::println);

    }




}


