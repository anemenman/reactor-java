package org.aa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Puzz019_any {
    public static void main(String[] args) {
        Flux<String> animalFlux = Flux.just(
            "aardvark", "elephant", "koala", "eagle", "kangaroo");
        Mono<Boolean> hasTMono = animalFlux.any(a -> a.contains("t"));
        StepVerifier.create(hasTMono)
            .expectNext(true)
            .verifyComplete();
        Mono<Boolean> hasZMono = animalFlux.any(a -> a.contains("z"));
        StepVerifier.create(hasZMono)
            .expectNext(false)
            .verifyComplete();
    }
}
