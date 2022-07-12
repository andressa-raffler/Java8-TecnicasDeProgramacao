package com.LetsCode.A7ProgramacaoAssincrona;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AppAssincrona {
/*
Normalmente, quando chamamos um método, esperamos que ele retorne um valor antes de continuar a execução do nosso
programa, esse tipo de processamento, é chamado de síncrono. Porém, existem situações em que é melhor chamar o método,
e continuar o processamento do nosso programa normalmente, e receber o resultado do método apenas quando o método
terminar a sua execução. Esse tipo de processamento é chamado de assíncrono, pois fazemos uma chamada para um método,
mas não esperamos a resposta antes de continuar.
É possível implementar processamento assíncrono com Threads, mas é um pouco complicado, pois o método run não possui
retorno, por isso o Java possui classes que facilitam esse tipo de processamento. Elas utilizam as threads na
implementação, mas o programador não precisa se preocupar com elas. Essas classes são a Future e a ComplatableFuture.
 */
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        futureExemploClass();
        CompletableFutureExemploClass();

    }
/*
No Java 8 foi introduzido a classe CompletableFuture, que funciona exatamente da mesma forma do Future, mas simplifica
um pouco as coisas. Com ela não precisamos criar o objeto ExecutorService, então economizamos algumas linhas de código.
 */
    private static void CompletableFutureExemploClass() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> soma(1000));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        Integer result = completableFuture.get(); //get trava a aplicaçao, chega aqui e espera pelo resultado
        System.out.println(result);
    }

    private static void futureExemploClass() throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool(); //Cria varias threads sozinho
        Future<Integer> futureTask = threadpool.submit(() -> soma(1000)); //Coloca o metodo dentro do runnable da thread

        /*
        Sem o while o fluxo da aplicaçao finaliza antes do java processar a thread e passar o resultado da soma
         */

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet..."); //while para simular a minha aplicaçao rodando
        }
        Integer result = futureTask.get();
        System.out.println(result);

        threadpool.shutdown();
    }

    public static Integer soma(Integer numero) {
        Integer soma = IntStream
                .range(0, numero)
                .sum();
        return soma;
    }

}
