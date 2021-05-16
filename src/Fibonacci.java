//Trabalho Multithreading - Sistemas Operacionais
//Gabriel Braz e Santos - 260569

public class Fibonacci implements Runnable {
    private volatile long delta;
    private int qtd;

    public Fibonacci (int qtd){
        this.qtd = qtd;
    }

    @Override
    public void run() {
        long start_time_fibonacci = System.currentTimeMillis();

        long first_number = 1;
        long second_number = 0;
        long result;

        for (int i = 0; i <= this.qtd; i++){
            result = first_number + second_number;

            first_number = second_number;
            second_number = result;

            System.out.println("Fibonacci - Qtd calculada: " + (i + 1) + " - Valor: " + result);
        }

        long end_time_fibonacci = System.currentTimeMillis();
        delta = end_time_fibonacci - start_time_fibonacci;
    }

    public long getDelta() {
        return delta;
    }
}
