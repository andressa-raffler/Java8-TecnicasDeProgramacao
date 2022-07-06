package com.LetsCode.A4ManipulacaoArquivos.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) throws IOException {

        leituraArquivoIO();
        criarArquivoIO();
        deletarArquivoIO();
        leituraArquivoNIO();
        deletarArquivoNIO();

    }

    private static void deletarArquivoNIO() {
        Path dir = Paths.get("File2.txt");
        try {
            Files.delete(dir);
        } catch (IOException e) {
          //  e.printStackTrace();
            System.out.println("Impossível deletar, arquivo nao encontrado");
        }

    }

    private static void leituraArquivoNIO() throws IOException {
        Path dir = Paths.get(System.getProperty("user.home"));
        Path file = Paths.get("lorem2.txt");
        Path path = dir.resolve(file);
        System.out.println(path.toAbsolutePath());
        var file2 = Files.lines(dir);

    }

    private static void deletarArquivoIO() {
        File file = new File("file_new.txt");
        file.delete();
    }

    private static void leituraArquivoIO() {
        File file = new File("lorem.txt"); //arquivo nao precisa existir e a linha roda

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //TryWithResources chama o close
            String line;                                                    //Buffered implementa interface closable
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void criarArquivoIO() throws IOException {
        File file = new File("lorem4.txt");
        try(var writter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writter)){
            bufferedWriter.write("Let's code!!!!");
        }
    }
}

