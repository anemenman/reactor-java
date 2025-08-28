package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Puzz005_Merge {
    public static void main(String[] args) {

        Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa")
            .delayElements(Duration.ofMillis(500));

        Flux<String> foodFlux = Flux
            .just("Lasagna", "Lollipops", "Apples")
            .delaySubscription(Duration.ofMillis(250))
            .delayElements(Duration.ofMillis(500));

        Flux<String> mergedFlux = characterFlux.mergeWith(foodFlux);
        mergedFlux.subscribe(f -> System.out.println("element: " + f));

        StepVerifier.create(mergedFlux)
            .expectNext("Garfield")
            .expectNext("Lasagna")
            .expectNext("Kojak")
            .expectNext("Lollipops")
            .expectNext("Barbossa")
            .expectNext("Apples")
            .verifyComplete();
    }
}
