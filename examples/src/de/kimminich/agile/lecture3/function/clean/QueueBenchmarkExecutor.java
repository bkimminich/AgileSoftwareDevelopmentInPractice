package de.kimminich.agile.lecture3.function.clean;

import java.util.Queue;
import java.util.Random;

public class QueueBenchmarkExecutor {

	Random random = new Random();
	long durationPuts = 0;
	long durationGets = 0;
	long minPut = Long.MAX_VALUE;
	long minGet = Long.MAX_VALUE;
	long maxPut = 1;
	long maxGet = -1;
	long gets = 0;
	long puts = 0;
	Queue<String> queue;
	int valueLength;
	int numberOfOperations;

	public QueueBenchmarkExecutor(Queue<String> queue, int valueLength,
			int numberOfOperations) {
		super();
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
		System.out.println("Benchmark Result[Type: "
				+ queue.getClass().getName() + "; Puts: " + puts + ", Min: "
				+ minPut + ", Max: " + maxPut + ", Duration: " + durationPuts
				+ "; Gets: " + gets + ", Min: " + minGet + ", Max: " + maxGet
				+ ", Duration: " + durationGets + "]");
	}

	private void performGet() {
		long time = System.nanoTime();
		queue.poll();
		time = System.nanoTime() - time;
		durationGets += time;
		gets++;
		minGet = Math.min(minGet, time);
		maxGet = Math.max(maxGet, time);
	}

	private void performPut() {
		long time = System.nanoTime();
		queue.offer(randomValue(random, valueLength));
		time = System.nanoTime() - time;
		durationPuts += time;
		puts++;
		minPut = Math.min(minPut, time);
		maxPut = Math.max(maxPut, time);
	}

	private String randomValue(Random random, int valueLength) {
		return Long.toHexString(Double.doubleToLongBits(random.nextDouble()));
	}

	private static enum OperationEnum {

		GET, PUT;

		private static final Random random = new Random();

		public static final OperationEnum randomOperation() {
			return random.nextDouble() > 0.7 ? GET : PUT;
		}

	}

}
