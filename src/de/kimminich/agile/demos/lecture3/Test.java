package de.kimminich.agile.demos.lecture3;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

    public static void main(String... args) {
        new Test().exec(new ArrayList<>(), 1000, 10000);
        new Test().exec(new HashSet<>(), 1000, 10000);
        new Test().exec(new TreeSet<>(), 1000, 10000);
        new Test().exec(new LinkedList<>(), 1000, 10000);
        new Test().exec(new LinkedBlockingQueue<>(), 1000, 10000);
    }

    public void exec(ArrayList<String> q, int len, int ops) {
        // ...
    }

    public void exec(Set<String> q, int len, int ops) {
        // ...
    }

    public void exec(Queue<String> q, int len, int ops) {
        Random rand = new Random();
        long durationPuts = 0, durationGets = 0;
        long minPut = Long.MAX_VALUE, minGet = Long.MAX_VALUE;
        long maxPut = 1, maxGet = -1;
        long gets = 0, puts = 0;
        for (int i = 0; i < ops; i++) {
            if (OperationEnum.randOps().equals(OperationEnum.PUT)) {
                long time = System.nanoTime();
                q.offer(randVal(rand, len));
                time = System.nanoTime() - time;
                durationPuts += time;
                puts++;
                minPut = Math.min(minPut, time);
                maxPut = Math.max(maxPut, time);
            } else {
                long time = System.nanoTime();
                q.poll();
                time = System.nanoTime() - time;
                durationGets += time;
                gets++;
                minGet = Math.min(minGet, time);
                maxGet = Math.max(maxGet, time);
            }
        }
        System.out.println("Benchmark Result[Type: " + q.getClass().getName()
                + "; Puts: " + puts + ", Min: " + minPut + ", Max: " + maxPut
                + ", Duration: " + durationPuts + "; Gets: " + gets + ", Min: "
                + minGet + ", Max: " + maxGet + ", Duration: " + durationGets
                + "]");
    }

    private String randVal(Random rand, int len) {
        return Long.toHexString(Double.doubleToLongBits(rand.nextDouble()));
    }

    private static enum OperationEnum {

        GET, PUT;

        private static final Random random = new Random();

        public static OperationEnum randOps() {
            return random.nextDouble() > 0.7 ? GET : PUT;
        }

    }

}
