package com.LetsCode.A6ProgramacaoParalela;

import java.security.SecureRandom;



public class PrintTask implements Runnable{
    public static void main(String[] args) {

        PrintTask printTask = new PrintTask("Andressa");
        printTask.run();


    }
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // tempo de adormecimento aleatório para a thread
    private final String taskName;
    // construtor
    //

    public PrintTask(String taskName1) {
        this.taskName = taskName1;
        sleepTime = 100;
    }


    public void run()
    {
        try // coloca a thread para dormir pela quantidade de tempo sleepTime
        {
            System.out.printf("%s going to sleep for %d milliseconds.%n",
                    taskName, sleepTime);
            Thread.sleep(sleepTime); // coloca a thread para dormirÿ
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread().interrupt(); // reinterrompe a thread
        }

        // imprime o nome da tarefa
        System.out.printf("%s done sleeping%n", taskName);
    }

} // fim da classe PrintTask

