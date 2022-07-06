package com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.model;

import java.time.LocalDate;

public class DadosDengue {
    private LocalDate data;
    private int qtdCasos;
    private double totalChuva;
    private double temperaturaMedia;
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public DadosDengue(LocalDate data, int qtdCasos, double totalChuva, double temperaturaMedia, double temperaturaMinima, double temperaturaMaxima) {
        this.data = data;
        this.qtdCasos = qtdCasos;
        this.totalChuva = totalChuva;
        this.temperaturaMedia = temperaturaMedia;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public LocalDate getData() {
        return data;
    }

    public int getQtdCasos() {
        return qtdCasos;
    }

    public double getTotalChuva() {
        return totalChuva;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }
}
