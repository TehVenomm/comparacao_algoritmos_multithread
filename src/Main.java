//Trabalho Multithreading - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

public class Main extends Thread
{
    public static void main(String[] args){
        System.out.println("Funcoes:");
        System.out.println("1 - Fibonacci");
        System.out.println("2 - Calculo Nro Primos");
        System.out.println("3 - Aproximacao Pi");

        Prime primos = new Prime(545);
        Fibonacci fibonacci = new Fibonacci(90);
        Pi pi = new Pi(1000000);

        // ----- ----- -----
        // Execucao sequencial.
        // ----- ----- -----

        long start_time_execucao = System.currentTimeMillis();

        //Calcula fibonacci 90x - mais que isso da overflow em variavel 'long'.
        //Poderia ter feito com 'BigInt' para evitar isso mas teria que importar a package...
        fibonacci.run();
        long delta_fibonacci_sequencial = fibonacci.getDelta();
        System.out.println(delta_fibonacci_sequencial + " ms usados em Fibonacci - Sequencial");

        // -----

        //Calcula 545 numeros e verifica quais sao primos.
        //545 encontra 100 numeros primos entre 0 -> N.
        primos.run();
        long delta_primos_sequencial = primos.getDelta();
        System.out.println(delta_primos_sequencial + " ms usados em Nros Primos - Sequencial");

        // -----

        // Aproximacao de PI calculada usando a formula Gregory-Leibniz.
        // pi.run(x); x sendo a quantidade de vezes que o calculo e realizado
        // >=1000000 iteracoes para encontrar o quinto digito correto, 3.1415...
        pi.run();
        long delta_pi_sequencial = pi.getDelta();
        System.out.println(delta_pi_sequencial + " ms usados em calculo de PI - Sequencial");

        // -----

        long end_time_execucao = System.currentTimeMillis();
        long delta_execucao_sequencial = end_time_execucao - start_time_execucao;

        System.out.println(delta_execucao_sequencial + " ms usados em Total - Sequencial");

        // ----- ----- -----
        // Execucao simultanea.
        // ----- ----- -----

        start_time_execucao = System.currentTimeMillis();

        Thread thread_fibonacci = new Thread(fibonacci);
        Thread thread_primos = new Thread(primos);
        Thread thread_pi = new Thread(pi);

        thread_fibonacci.start();
        thread_primos.start();
        thread_pi.start();

        while (thread_fibonacci.isAlive() || thread_primos.isAlive() || thread_pi.isAlive()){
            //Esperando...
        }

        end_time_execucao = System.currentTimeMillis();
        long delta_execucao_simultaneo = end_time_execucao - start_time_execucao;

        System.out.println(delta_execucao_simultaneo + " ms usados no Total - Simultaneo");

        System.out.println("Threads terminaram execucao!");

        System.out.println("\n-----------");
        System.out.println("\nTEMPO DE EXECUCAO - SEM THREADS: ");
        System.out.println("Calc Fibonacci\t\t- Sequencial: " + delta_fibonacci_sequencial + " ms");
        System.out.println("Calc Nros Primos\t- Sequencial: " + delta_primos_sequencial + " ms");
        System.out.println("Aprox PI\t\t\t- Sequencial: " + delta_pi_sequencial + " ms");
        System.out.println("TOTAL\t\t\t\t- Sequencial: " + delta_execucao_sequencial + " ms");

        System.out.println("\n-----------");
        System.out.println("\nTEMPO DE EXECUCAO - COM THREADS: ");
        System.out.println("Calc Fibonacci\t\t- Simultaneo: " + fibonacci.getDelta() + " ms");
        System.out.println("Calc Nros Primos\t- Simultaneo: " + primos.getDelta() + " ms");
        System.out.println("Aprox PI\t\t\t- Simultaneo: " + pi.getDelta() + " ms");
        System.out.println("TOTAL\t\t\t\t- Simultaneo: " + delta_execucao_simultaneo + " ms");

        System.out.println("\n-----------");

    }
}