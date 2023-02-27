import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Thread parallelThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            double result = multiplyAndSum(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Parallel result: " + result + " in " + (endTime - startTime) + " milliseconds");
        });

        Thread serialThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            double result = serialMultiplyAndSum(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Serial result: " + result + " in " + (endTime - startTime) + " milliseconds");
        });

        parallelThread.start();
        serialThread.start();

        try {
            parallelThread.join();
            serialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static double multiplyAndSum(int[] arr) {
        Random random = new Random();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double randomValue = random.nextDouble() * (0.9 - 0.1) + 0.1;
            sum += arr[i] * randomValue;
        }
        return sum;
    }

    public static double serialMultiplyAndSum(int[] arr) {
        Random random = new Random();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double randomValue = random.nextDouble() * (0.9 - 0.1) + 0.1;
            sum += arr[i] * randomValue;
        }
        return sum;
    }
}
