package com.LetsCode.A7ProgramacaoAssincrona;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AppProf {

    private static String API_URL = "http://localhost:8080/api/message";

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        //exemploClassExecutorService();
        //exemploClassCompletableFuture();
        //exemplo1();
        //completableFutureSemValor();
        //exemploApply();
       // exemploListener();
       // exemploCombine();
        exemploApi();

        System.out.println("Fim do método main");

        TimeUnit.MINUTES.sleep(1);
    }

    private static void exemploApi() throws IOException, InterruptedException {

        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(URI.create(API_URL + "?message=Chamada1"))
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return response.body();
        }).thenAccept(System.out::println);

       // future.get(); //faz com que o main só finalize depois da msg enviada

        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(URI.create(API_URL + "?message=Chamada2"))
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return response.body();
        }).thenAccept(System.out::println); //thenAccept é metodo final,


        CompletableFuture.allOf(future1,future2); // "allOf"Aguarde que todas as threads finalizem
        /*
        colocar CompletableFuture.allOf(future1,future2).get ai a aplicaçao trava até finalizar as threads
        e só entao finaliza o método main.
         */
    }

    private static void exemploCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Olá ";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Turma";
        });

        //var future = f1.thenCombine(f2, (resultadoF1, resultadoF2) -> resultadoF1 + resultadoF2);
        //System.out.println(future.get());

        f1.thenCombine(f2, (resultadoF1, resultadoF2) -> resultadoF1 + resultadoF2)
                .thenAccept(System.out::println);
    }



    /* exemploListener 'retorna'void mas chama outro método.  */
    private static void exemploListener() throws ExecutionException, InterruptedException {
        var t = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Future sem valor";
        }).thenAccept(AppProf::updateDatabase);
    }

    private static void updateDatabase(String message) {
        System.out.println(message);
    }

    private static void exemploApply() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> soma(1000))
                .thenApply(v -> "Soma total: " + v);

        try {
            var result = completableFuture.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    /* O completableFutureSemValor "retorna" um void, ou seja, nao tem retorno, logo, nao precisa do .get */

    private static void completableFutureSemValor() throws ExecutionException, InterruptedException {
        var ret = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Future sem valor");
        });

    }
    /* Exemplo1 possui retorno, String, o future.complete é utilizado para dar o resultado 'String' esperado pela
    Thread O .get trava a aplicaçao até a Thread ter um retorno, caso nao seja fornecido, fica travado p/ sempre */
    private static void exemplo1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("Olá");
        System.out.println(future.get());
    }

    private static void exemploClassCompletableFuture() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return soma(1000);
        });

        try {
            var result = completableFuture.get();
            System.out.println("Valor: " + result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void exemploClassExecutorService() throws InterruptedException, ExecutionException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Integer> futureTask = threadpool.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return soma(1000);
        });

        var result = futureTask.get();
        System.out.println("Valor: " + result);
        System.out.println("Fim");

        threadpool.shutdown();
    }
    public static Integer soma(Integer numero) {

        return IntStream
                .range(0, numero)
                .sum();
    }
}