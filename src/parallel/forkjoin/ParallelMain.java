package parallel.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static parallel.forkjoin.MyLogger.log;

public class ParallelMain {

    public static void main(String[] args) {
        int processorCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCount = " + processorCount + ", commonPool = " +
                commonPool.getParallelism());
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 8)
                .parallel() // 추가
                .map(HeavyJob::heavyTask)
                .reduce(0, (a, b) -> a + b);
        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

}
