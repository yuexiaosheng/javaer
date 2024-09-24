package com.javaer.demo02_concurrent_problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.openjdk.jcstress.infra.runners.TestConfig;
import org.openjdk.jcstress.infra.collectors.TestResultCollector;
import org.openjdk.jcstress.infra.runners.Runner;
import org.openjdk.jcstress.infra.runners.StateHolder;
import org.openjdk.jcstress.util.Counter;
import org.openjdk.jcstress.vm.WhiteBoxSupport;
import java.util.concurrent.ExecutionException;
import com.javaer.demo02_concurrent_problem.Test03Ordering;
import org.openjdk.jcstress.infra.results.I_Result_jcstress;

public class Test03Ordering_jcstress extends Runner<I_Result_jcstress> {

    volatile StateHolder<Test03Ordering, I_Result_jcstress> version;

    public Test03Ordering_jcstress(TestConfig config, TestResultCollector collector, ExecutorService pool) {
        super(config, collector, pool, "com.javaer.demo02_concurrent_problem.Test03Ordering");
    }

    @Override
    public void sanityCheck() throws Throwable {
        sanityCheck_API();
        sanityCheck_Footprints();
    }

    private void sanityCheck_API() throws Throwable {
        final Test03Ordering t = new Test03Ordering();
        final Test03Ordering s = new Test03Ordering();
        final I_Result_jcstress r = new I_Result_jcstress();
        Collection<Future<?>> res = new ArrayList<>();
        res.add(pool.submit(() -> t.actor1(r)));
        res.add(pool.submit(() -> t.actor2(r)));
        for (Future<?> f : res) {
            try {
                f.get();
            } catch (ExecutionException e) {
                throw e.getCause();
            }
        }
    }

    private void sanityCheck_Footprints() throws Throwable {
        config.adjustStrides(size -> {
            version = new StateHolder<>(new Test03Ordering[size], new I_Result_jcstress[size], 2, config.spinLoopStyle);
            final Test03Ordering t = new Test03Ordering();
            for (int c = 0; c < size; c++) {
                I_Result_jcstress r = new I_Result_jcstress();
                Test03Ordering s = new Test03Ordering();
                version.rs[c] = r;
                version.ss[c] = s;
                s.actor1(r);
                s.actor2(r);
            }
        });
    }

    @Override
    public Counter<I_Result_jcstress> internalRun() {
        version = new StateHolder<>(new Test03Ordering[0], new I_Result_jcstress[0], 2, config.spinLoopStyle);

        control.isStopped = false;
        Collection<Future<Counter<I_Result_jcstress>>> tasks = new ArrayList<>();
        tasks.add(pool.submit(this::actor1));
        tasks.add(pool.submit(this::actor2));

        try {
            TimeUnit.MILLISECONDS.sleep(config.time);
        } catch (InterruptedException e) {
        }

        control.isStopped = true;

        waitFor(tasks);

        Counter<I_Result_jcstress> counter = new Counter<>();
        for (Future<Counter<I_Result_jcstress>> f : tasks) {
            try {
                counter.merge(f.get());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        return counter;
    }

    public final void jcstress_consume(StateHolder<Test03Ordering, I_Result_jcstress> holder, Counter<I_Result_jcstress> cnt, int a, int actors) {
        Test03Ordering[] ss = holder.ss;
        I_Result_jcstress[] rs = holder.rs;
        int len = ss.length;
        int left = a * len / actors;
        int right = (a + 1) * len / actors;
        for (int c = left; c < right; c++) {
            I_Result_jcstress r = rs[c];
            Test03Ordering s = ss[c];
            ss[c] = new Test03Ordering();
            cnt.record(r);
            r.r1 = 0;
        }
    }

    public final void jcstress_updateHolder(StateHolder<Test03Ordering, I_Result_jcstress> holder) {
        if (!holder.tryStartUpdate()) return;
        Test03Ordering[] ss = holder.ss;
        I_Result_jcstress[] rs = holder.rs;
        int len = ss.length;

        int newLen = holder.updateStride ? Math.max(config.minStride, Math.min(len * 2, config.maxStride)) : len;

        Test03Ordering[] newS = ss;
        I_Result_jcstress[] newR = rs;
        if (newLen > len) {
            newS = Arrays.copyOf(ss, newLen);
            newR = Arrays.copyOf(rs, newLen);
            for (int c = len; c < newLen; c++) {
                newR[c] = new I_Result_jcstress();
                newS[c] = new Test03Ordering();
            }
         }

        version = new StateHolder<>(control.isStopped, newS, newR, 2, config.spinLoopStyle);
        holder.finishUpdate();
   }

    public final Counter<I_Result_jcstress> actor1() {

        Counter<I_Result_jcstress> counter = new Counter<>();
        while (true) {
            StateHolder<Test03Ordering,I_Result_jcstress> holder = version;
            if (holder.stopped) {
                return counter;
            }

            Test03Ordering[] ss = holder.ss;
            I_Result_jcstress[] rs = holder.rs;
            int size = ss.length;

            holder.preRun();

            for (int c = 0; c < size; c++) {
                Test03Ordering s = ss[c];
                I_Result_jcstress r = rs[c];
                r.trap = 0;
                s.actor1(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 0, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    public final Counter<I_Result_jcstress> actor2() {

        Counter<I_Result_jcstress> counter = new Counter<>();
        while (true) {
            StateHolder<Test03Ordering,I_Result_jcstress> holder = version;
            if (holder.stopped) {
                return counter;
            }

            Test03Ordering[] ss = holder.ss;
            I_Result_jcstress[] rs = holder.rs;
            int size = ss.length;

            holder.preRun();

            for (int c = 0; c < size; c++) {
                Test03Ordering s = ss[c];
                I_Result_jcstress r = rs[c];
                r.trap = 0;
                s.actor2(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 1, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

}
