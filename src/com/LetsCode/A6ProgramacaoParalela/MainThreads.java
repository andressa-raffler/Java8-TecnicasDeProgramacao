package com.LetsCode.A6ProgramacaoParalela;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThreads {
    private static int numero;
    public static void main(String[] args) throws InterruptedException {
        //Threads();
        //paralelismo();
        executorService();
    }

    private static void executorService() throws InterruptedException {
        Instant ini = Instant.now();
        Contador contador = new Contador();

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(contador);
        es.execute(contador);
        es.shutdown();
        es.awaitTermination(50,TimeUnit.SECONDS);

        Instant fim = Instant.now();
        Duration duration = Duration.between(ini,fim);
        System.out.println("Duracao total: "+duration.toMillis()+"ms");


            }


    private static void paralelismo() throws InterruptedException {
        Thread t1 = new Thread(()-> {
            try {
            Thread.sleep(7000);
                System.out.println("Duracao de 7s");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                Thread.sleep(5000);
                System.out.println("Duracao de 5s");
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
        });
        Instant ini = Instant.now();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Instant fim = Instant.now();
        Duration duration = Duration.between(ini,fim);
        System.out.println("Duracao total: "+duration.toSeconds()+"S");
        System.out.println("Duracao da thread mais lenta");

    }

    private static void Threads() {
        var contador = new Contador();
        Thread[] threads = new Thread[5];
        Instant ini = Instant.now();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(contador);
            threads[i].start();
           // threads[i].join(); //Faz com que o código seja executado na ordem que coloquei, e nao
                                //deixa pras threads serem executadas depois, por isso, imprime a
                                //duraçao no final
                                //RODA TUDO DENTRO DA MAIN
                                //Perde o paralelismo
        }
        Instant fim = Instant.now();
        Duration duration = Duration.between(ini, fim);
        System.out.println("Duraçao: "+duration.toMillis()+"ms");
    }

    public static class Contador implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(10); //atrasa a execuçao
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            synchronized (this) {
                numero++;
                System.out.println(Thread.currentThread().getName() + ": " + numero);
            }
        }
    }
}
