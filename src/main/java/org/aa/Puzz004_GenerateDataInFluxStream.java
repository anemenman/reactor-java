package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Puzz004_GenerateDataInFluxStream {
    public static void main(String[] args) {
        Flux<Integer> intervalFlux = Flux.range(1, 5);
        StepVerifier.create(intervalFlux)
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .expectNext(4)
            .expectNext(5)
            .verifyComplete();

        Flux<Long> intervalFlux2 = Flux.interval(Duration.ofSeconds(1)).take(5);
    }
}
