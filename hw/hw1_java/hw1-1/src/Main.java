public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("This is a task");
            });
            thread.start();
        }
    }
}
