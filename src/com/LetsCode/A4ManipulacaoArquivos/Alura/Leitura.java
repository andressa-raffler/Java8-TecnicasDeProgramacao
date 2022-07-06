package com.LetsCode.A4ManipulacaoArquivos.Alura;


import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Leitura {

        public static void main(String[] args) throws Exception {
        //    Leitura1();
            Leitura2ComScanner();
        }

        public static void Leitura1() throws IOException {
            //Fluxo de Entrada com Arquivo
            InputStream fis = new FileInputStream("lorem.txt");
            Reader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();

            while(linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }

            br.close();
        }

        public static void Leitura2ComScanner() throws Exception {

            Scanner scanner = new Scanner(new File("contas.csv"));

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
                Scanner linhaScanner = new Scanner(linha);
                linhaScanner.useLocale(Locale.US); //PARA NAO DAR ERRO NO DOUBLE COM PONTO
                linhaScanner.useDelimiter(","); //PARSEANDO com o Scanner
                String valor1 = linhaScanner.next();
                int valor2 = linhaScanner.nextInt();
                int valor3 = linhaScanner.nextInt();
                String valor4 = linhaScanner.next();
                double valor5 = linhaScanner.nextDouble();

                System.out.println(valor1 + valor2 + valor3 + valor4 + valor5);
                linhaScanner.close();

//                String[] valores = linha.split(","); //PARSEANDO com o String
//                System.out.println(Arrays.toString(valores));

            }
            scanner.close();


        }
    }

