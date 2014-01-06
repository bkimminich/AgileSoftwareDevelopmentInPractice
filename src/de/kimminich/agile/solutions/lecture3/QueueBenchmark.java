package de.kimminich.agile.solutions.lecture3;

import java.util.Queue;
import java.util.Random;

public class QueueBenchmark {

    Random random = new Random();

    /* All durations are measured in nanoseconds */
    long totalDurationPuts = 0;
    long totalDurationGets = 0;
    long minPutDuration = Long.MAX_VALUE;
    long minGetDuration = Long.MAX_VALUE;
    long maxPutDuration = -1;
    long maxGetDuration = -1;

    long numberOfGets = 0;
    long numberOfPuts = 0;

    Queue<String> queue;
    int valueLength;
    int numberOfOperations;

    public QueueBenchmark(Queue<String> queue, int valueLength, int numberOfOperations) {
        this.queue = queue;
        this.valueLength = valueLength;
        this.numberOfOperations = numberOfOperations;
    }

    public void execute() {
        for (int i = 0; i < numberOfOperations; i++) {
            if (OperationEnum.randomOperation().equals(OperationEnum.PUT)) {
                performPut();
            } else {
                performGet();
            }
        }
        printResult();
    }

    private void printResult() {
        System.out.println("Benchmark Result[Type: " + queue.getClass().getName() + "; Puts: " + numberOfPuts + ", Min: "
                + minPutDuration + ", Max: " + maxPutDuration + ", Duration: " + totalDurationPuts + "; Gets: " + numberOfGets
                + ", Min: " + minGetDuration + ", Max: " + maxGetDuration + ", Duration: " + totalDurationGets + "]");
    }

    private void performGet() {
        long time = System.nanoTime();
        queue.poll();
        time = System.nanoTime() - time;
        totalDurationGets += time;
        numberOfGets++;
        minGetDuration = Math.min(minGetDuration, time);
        maxGetDuration = Math.max(maxGetDuration, time);
    }

    private void performPut() {
        long time = System.nanoTime();
        queue.offer(randomValue(random, valueLength));
        time = System.nanoTime() - time;
        totalDurationPuts += time;
        numberOfPuts++;
        minPutDuration = Math.min(minPutDuration, time);
        maxPutDuration = Math.max(maxPutDuration, time);
    }

    private String randomValue(Random random, int valueLength) {
        /* Creates a random 16-character hex string, like 3fdac44b8068018e */
        return Long.toHexString(Double.doubleToLongBits(random.nextDouble()));
    }

    private static enum OperationEnum {

        GET,
        PUT;

        private static final Random random = new Random();

        public static final OperationEnum randomOperation() {
            /*
             * To let the queue grow steadily during the benchmark, ~70% of the operations are PUTs. This also prevents testing
             * lots of polls on an empty queue which might falsify the benchmark results.
             */
            return random.nextDouble() > 0.7 ? GET : PUT;
        }

    }

}
