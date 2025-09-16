package org.aa;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Puzz015_buffer_flatMap_log {
    public static void main(String[] args) {
        Flux.just(
                "apple", "orange", "banana", "kiwi", "strawberry")
            .buffer(3)
            .flatMap(x ->
                Flux.fromIterable(x)
                    .map(y -> y.toUpperCase())
                    .subscribeOn(Schedulers.parallel())
                    .log()
            ).subscribe();
    }
}
