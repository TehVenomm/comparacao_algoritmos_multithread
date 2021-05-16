//Trabalho Multithreading - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

public class Prime implements Runnable {
    private volatile long delta;
    private int objetivo;

    public Prime (int objetivo){
        this.objetivo = objetivo;
    }

    @Override
    public void run() {
        long start_time_primes = System.currentTimeMillis();

        int first_number = 2;
        int max_number = this.objetivo;
        boolean is_prime;
        int qtd_primos = 0;

        for (int i = first_number; i <= max_number; i++) {
            is_prime = true;

            for (int j = 2; j <= (i - 1); j++) {
                if ((i % j) == 0) {
                    is_prime = false;
                }
            }

            if (is_prime){
                qtd_primos++;
                System.out.println("Primos - Qtd encontrada: " + qtd_primos + " - Valor: " + i);
            }
        }

        long end_time_primes = System.currentTimeMillis();
        delta = end_time_primes - start_time_primes;
    }

    public long getDelta() {
        return delta;
    }
}
