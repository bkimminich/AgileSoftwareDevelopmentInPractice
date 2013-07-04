package de.kimminich.agile.lecture23.clean;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueBenchmark {

	public static void main(String... args) {
		new QueueBenchmarkExecutor(new LinkedList<String>(), 1000, 10000)
				.execute();
		new QueueBenchmarkExecutor(new LinkedBlockingQueue<String>(), 1000,
				10000).execute();
	}

}
