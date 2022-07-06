package com.LetsCode.A2Lambda.ExercicioListaTelefonica;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Contato{
    private String nome;
    private long telefone;
    private LocalDate aniversario;
    private Integer idade;


    public Contato(String nome, long telefone, LocalDate aniversario) {
        this.nome = nome;
        this.telefone = telefone;
        this.aniversario = aniversario;
        this.idade = (LocalDate.now().getYear()-aniversario.getYear());
    }

    public String getNome() {
        return nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Telefone: %d - Aniversário: %s - Idade: %d",
                this.nome,
                this.telefone,
                this.aniversario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                this.idade);
    }
}
