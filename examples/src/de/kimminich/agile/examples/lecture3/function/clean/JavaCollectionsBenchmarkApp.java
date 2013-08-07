package de.kimminich.agile.examples.lecture3.function.clean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingQueue;

public class JavaCollectionsBenchmarkApp {

    public static void main(String... args) {
        new ListBenchmark(new ArrayList<String>(), 1000, 10000).execute();
        new SetBenchmark(new HashSet<String>(), 1000, 10000).execute();
        new SetBenchmark(new TreeSet<String>(), 1000, 10000).execute();
        new QueueBenchmark(new LinkedList<String>(), 1000, 10000).execute();
        new QueueBenchmark(new LinkedBlockingQueue<String>(), 1000, 10000).execute();
    }

}
