package edu.harvard.iq.dataverse.benchmark;

import edu.harvard.iq.dataverse.api.Util;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
//@Warmup(iterations = 3)
//@Measurement(iterations = 8)
public class BenchmarkApiUtil {

    @Param({"10000000"})
    private int N;

    private List<String> TEST_DATA = Arrays.asList("asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ", "asdasd", "asdas", " asdf ");

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkApiUtil.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
    }

    @Benchmark
    public void benchmarkApiUtil(Blackhole bh) {
        bh.consume(Util.removeDuplicatesNullsEmptyStrings(TEST_DATA));
    }
}