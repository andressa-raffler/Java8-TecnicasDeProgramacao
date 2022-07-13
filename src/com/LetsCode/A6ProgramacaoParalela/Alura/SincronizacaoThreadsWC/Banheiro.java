package com.LetsCode.A6ProgramacaoParalela.Alura.SincronizacaoThreadsWC;

public class Banheiro {

        public void fazNumero1() {

            String nome = Thread.currentThread().getName();
            System.out.println(nome+" batendo na porta");

            /*
                private Lock lock = new ReentrantLock();
                public void fazNumero1() { lock.lock();....
                o lock substitui o Syncronized e permite que se passe tempo de bloqueio
                ex: boolean locked = lock.tryLock(5, TimeUnit.SECONDS); //5s
                ou desbloquear com o unLock()
             */

            synchronized (this){ //BANHEIRO PODERA SER ACESSADO POR UMA UNICA THREAD POR VEZ, chave tb chamada de MUTEX, chave do objeto
                System.out.println(nome+" entrando no banheiro");
                System.out.println(nome+" fazendo coisa rapida");

                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(nome+" dando descarga");
                System.out.println(nome+" lavando a mao");
                System.out.println(nome+" saindo do banheiro");
            }
        }

        public void fazNumero2() {

            String nome = Thread.currentThread().getName();
            System.out.println(nome+" batendo na porta");


            synchronized (this) {  //BANHEIRO PODERA SER ACESSADO POR UMA UNICA THREAD POR VEZ
                System.out.println(nome + " entrando no banheiro");
                System.out.println(nome + " fazendo coisa demorada");

                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(nome + " dando descarga");
                System.out.println(nome + " lavando a mao");
                System.out.println(nome + " saindo do banheiro");
            }
        }
    }

