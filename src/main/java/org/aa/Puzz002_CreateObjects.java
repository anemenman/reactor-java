package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Puzz002_CreateObjects {
    public static void main(String[] args) {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");

        fruitFlux.subscribe(f -> System.out.println("Here’s some fruit: " + f));

        System.out.println("---------------");

        StepVerifier.create(fruitFlux)
            .expectNext("Apple")
            .expectNext("Orange")
            .expectNext("Grape")
            .expectNext("Banana")
            .expectNext("Strawberry")
            .verifyComplete();
    }
}
