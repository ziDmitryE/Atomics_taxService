import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Account shop = new Account();
        Thread thread1 = new Thread(null, () -> shop.transfer(getArray(5)), "Магазин 1");
        Thread thread2 = new Thread(null, () -> shop.transfer(getArray(10)), "Магазин 2");
        Thread thread3 = new Thread(null, () -> shop.transfer(getArray(15)), "Магазин 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\nВыручка по всем магазинам: " + shop.getCurrent());
    }

    public static int[] getArray(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new Random().nextInt(1000);
        }
        return array;
    }
}
