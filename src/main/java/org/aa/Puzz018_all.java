package org.aa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Puzz018_all {
    public static void main(String[] args) {
        Flux<String> animalFlux = Flux.just(
            "aardvark", "elephant", "koala", "eagle", "kangaroo");
        Mono<Boolean> hasAMono = animalFlux.all(a -> a.contains("a"));
        StepVerifier.create(hasAMono)
            .expectNext(true)
            .verifyComplete();
        Mono<Boolean> hasKMono = animalFlux.all(a -> a.contains("k"));
        StepVerifier.create(hasKMono)
            .expectNext(false)
            .verifyComplete();
    }
}
