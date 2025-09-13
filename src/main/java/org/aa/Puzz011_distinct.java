package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Puzz011_distinct {
    public static void main(String[] args) {
        Flux<String> animalFlux = Flux.just(
                "dog", "cat", "bird", "dog", "bird", "anteater")
            .distinct();
        StepVerifier.create(animalFlux)
            .expectNext("dog", "cat", "bird", "anteater")
            .verifyComplete();
    }
}
