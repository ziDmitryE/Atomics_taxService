import java.util.concurrent.atomic.LongAdder;

public class Account {

    LongAdder account = new LongAdder();

    public void transfer(int[] array) {
        long count = 0;
        for (int j : array) {
            account.add(j);
            count += j;
        }
        System.out.printf("%s имеет выручку за день: %d рублей\n",
                Thread.currentThread().getName(), count);
    }

    public long getCurrent() {
        return account.sum();
    }
}
