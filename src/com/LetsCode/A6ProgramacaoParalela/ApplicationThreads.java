package com.LetsCode.A6ProgramacaoParalela;

public class ApplicationThreads {

    private static int numero;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                numero++;
                System.out.println("Número: "+numero);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }
}
