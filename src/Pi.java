//Trabalho Multithreading - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

public class Pi implements Runnable {
    private volatile long delta;
    private long iterations;

    public Pi (long iterations){
        this.iterations = iterations;
    }

    @Override
    public void run() {
        //Usando a formula Gregory-Leibniz.
        // pi = (4/1) - (4/3) + (4/5) - (4/7) +  ... + (4/n)
        long start_time_pi = System.currentTimeMillis();

        double x = 1;
        double pi_approx = 4/x;

        for (long i = 1; i <= this.iterations; i++) {
            x += 2;

            if (i % 2 == 0) {
                pi_approx += (4 / x);

            } else {
                pi_approx -= (4 / x);
            }

            if ((i % 10000) == 0) {
                System.out.println("PI - Iteracao calculada: " + i + " - Valor: " + pi_approx);
            }
        }

        System.out.println(pi_approx + " -> valor apos " + this.iterations + " iteracoes de calculo PI");
        System.out.println(Math.PI + " -> Valor PI definido pelo java");

        long end_time_pi = System.currentTimeMillis();
        delta = end_time_pi - start_time_pi;
    }

    public long getDelta() {
        return delta;
    }
}
