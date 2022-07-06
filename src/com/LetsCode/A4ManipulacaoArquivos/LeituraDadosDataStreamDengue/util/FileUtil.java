package com.LetsCode.A4ManipulacaoArquivos.LeituraDadosDataStreamDengue.util;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FileUtil<T> {
    private final String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public List<T> readFile(Function<String, T> mapper) throws IOException {
        var file = new FileInputStream(this.fileName);

        if (file == null) {
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
            return reader.lines()
                    .skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());
        }
    }
}