package com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue;


import com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.mappers.DadosDengueMapper;
import com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.model.DadosDengue;
import com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.service.DengueService;
import com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.util.FileUtil;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        var fileUtil = new FileUtil<DadosDengue>("dengue-dataset.csv");
        var dadosDengue = fileUtil.readFile(new DadosDengueMapper());
        var dengueService = new DengueService(dadosDengue);
        dengueService.printAnoComMaisDengue();
        System.out.println();
        dengueService.printTotalCasosDengue();
        System.out.println();
        dengueService.PrintChuvaAcumuladaPorAno();

    }
}
