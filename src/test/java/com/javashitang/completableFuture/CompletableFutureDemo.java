package com.javashitang.completableFuture;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lilimin
 * @since 2020-08-29
 */
public class CompletableFutureDemo {

    @Test
    public void test1() throws Exception {
        CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(() -> System.out.println("hello"));
        // null
        System.out.println(voidFuture.get());

        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "hello");
        // end
        System.out.println(stringFuture.get());
    }


    @Test
    public void test2() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        stringFuture.complete("word");
        // word
        System.out.println(stringFuture.get());
    }

    @Test
    public void test3() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "hello");
        TimeUnit.SECONDS.sleep(1);
        stringFuture.complete("word");
        // hello
        System.out.println(stringFuture.get());
    }

    @Test
    public void test4() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        // java.util.concurrent.ExecutionException: java.lang.RuntimeException
        stringFuture.completeExceptionally(new RuntimeException());
        // hello
        System.out.println(stringFuture.get());
    }

    @Test
    public void test5() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "hello");
        TimeUnit.SECONDS.sleep(1);
        stringFuture.completeExceptionally(new RuntimeException());
        // hello
        System.out.println(stringFuture.get());
    }

    @Test
    public void test6() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "hello");
        stringFuture = stringFuture.thenApply((x) -> x + " world").thenApply(String::toUpperCase);
        // HELLO WORLD
        System.out.println(stringFuture.get());
    }

    @Test
    public void test7() throws Exception {
        CompletableFuture<String> stringFuture = CompletableFuture.supplyAsync(() -> "hello");
        stringFuture = stringFuture.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " world"));
        // hello world
        System.out.println(stringFuture.get());
    }

    @Test
    public void test8() throws Exception {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future2";
        });
        // from future1 和 from future2 随机输出
        CompletableFuture<Void> future = future1.acceptEither(future2, str -> System.out.println(str));
        future.get();
    }

    @Test
    public void test9() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "test1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "test2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "test3");

        // test1 test2 test3
        CompletableFuture.allOf(future1, future2, future3).thenApply(v ->
                Stream.of(future1, future2, future3).
                        map(CompletableFuture::join).
                        collect(Collectors.joining(" "))).thenAccept(System.out::print);
    }

    @Test
    public void test11() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "test1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "test2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "test3");

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);
        // test1
        System.out.println(future.get());

    }


    @Test
    public void test12() throws Exception {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "from future2";
        });
        CompletableFuture<String> future = future1.applyToEither(future2, str -> str);
        // from future1 和 from future2 随机输出
        System.out.println(future.get());
    }

    @Test
    public void test13() {
        // hello world
        CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(s -> s + " world").thenAccept(System.out::print);
    }

    @Test
    public void test14() {
        // hello world
        CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(s -> s + " world").whenComplete((result, throwable) -> System.out.println(result));
    }

    @Test
    public void test15() {
        CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(s -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return s + " world";})
                .whenComplete((result, throwable) -> System.out.println(result));
    }
}
