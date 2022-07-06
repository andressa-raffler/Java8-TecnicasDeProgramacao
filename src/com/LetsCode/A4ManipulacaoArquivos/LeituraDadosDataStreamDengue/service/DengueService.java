package com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.service;

import com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.model.DadosDengue;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DengueService {

        private final List<DadosDengue> dadosDengue;

    public DengueService(List<DadosDengue> dadosDengue) {
        this.dadosDengue = dadosDengue;
    }



    public void printAnoComMaisDengue(){
        var dados = dadosDengue.stream().collect(Collectors.groupingBy(d -> d.getData().getYear(),
                        Collectors.summingInt(DadosDengue::getQtdCasos)))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        dados.ifPresent(c -> System.out.printf("%d é o ano com mais casos de dengue : %d", c.getKey(), c.getValue()));

    }

    public void printTotalCasosDengue(){
        int sum = dadosDengue.stream()
                .mapToInt(d -> d.getQtdCasos())
                .sum();
        System.out.printf("Total de casos de dengue: %d",sum);
    }

    public void PrintChuvaAcumuladaPorAno(){
        var dados2 = dadosDengue.stream().collect(Collectors.groupingBy(d -> d.getData().getYear(),
                Collectors.summingDouble(DadosDengue::getTotalChuva)))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

    dados2.ifPresent(c -> System.out.printf("ano %d, total casos %f, ",c.getKey(), c.getValue()));
    }


}
