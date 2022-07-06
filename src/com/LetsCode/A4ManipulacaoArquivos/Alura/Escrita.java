package com.LetsCode.A4ManipulacaoArquivos.Alura;

import java.io.*;

public class Escrita {

        public static void main(String[] args) throws IOException {
            Escrita1();
            Escrita2FileWriter();
            Escrita3PrintStream();
            
            
        }

    private static void Escrita3PrintStream() throws IOException {

        //Alto nivel, printstream estava na primeira versao do java, antes dos readers e writers
       // PrintStream ps = new PrintStream("lorem3.txt");
        PrintWriter ps = new PrintWriter("lorem3.txt"); //FUNCIONA IGUAL A LINHA ACIMA

        ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ");
        ps.println("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");
        ps.println("id est laborum.");

        ps.close();

    }

    private static void Escrita2FileWriter() throws IOException {


        //FileWriter cria o objeto e Buffered Writer popula
        BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ");
        bw.newLine();
        bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");
        bw.newLine();
        bw.write("id est laborum.");
        bw.newLine();
        bw.close();
    }

    public static void Escrita1() throws IOException{
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
    }

