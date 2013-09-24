package de.kimminich.agile.examples.lecture3.function.bad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {

	public static void main(String... args) {
		new Test().exec(new ArrayList<String>(), 1000, 10000);
		new Test().exec(new HashSet<String>(), 1000, 10000);
		new Test().exec(new TreeSet<String>(), 1000, 10000);
		new Test().exec(new LinkedList<String>(), 1000, 10000);
		new Test().exec(new LinkedBlockingQueue<String>(), 1000, 10000);
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

		public static final OperationEnum randOps() {
			return random.nextDouble() > 0.7 ? GET : PUT;
		}

	}

}
