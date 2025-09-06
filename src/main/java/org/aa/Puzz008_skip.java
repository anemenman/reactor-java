package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Puzz008_skip {
    public static void main(String[] args) {
        Flux<String> countFlux = Flux.just(
                "one", "two", "skip a few", "ninety nine", "one hundred")
            .skip(3);
        StepVerifier.create(countFlux)
            .expectNext("ninety nine", "one hundred")
            .verifyComplete();
    }
}
