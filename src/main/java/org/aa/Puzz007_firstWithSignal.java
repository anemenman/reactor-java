package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Puzz007_firstWithSignal {

    public static void main(String[] args) {
        Flux<String> slowFlux = Flux.just("tortoise", "snail", "sloth")
            .delaySubscription(Duration.ofMillis(100));
        Flux<String> fastFlux = Flux.just("hare", "cheetah", "squirrel");
        Flux<String> firstFlux = Flux.firstWithSignal(slowFlux, fastFlux);
        StepVerifier.create(firstFlux)
            .expectNext("hare")
            .expectNext("cheetah")
            .expectNext("squirrel")
            .verifyComplete();
    }
}
