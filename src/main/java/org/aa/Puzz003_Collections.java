package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.stream.Stream;

public class Puzz003_Collections {
    public static void main(String[] args) {
        String[] fruits = new String[]{"Apple", "Orange", "Grape", "Banana", "Strawberry"};
        //Flux<String> fruitFlux = Flux.fromIterable(fruitList);

//        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        //Flux<String> fruitFlux = Flux.fromStream(fruitStream);
        Flux<String> fruitFlux = Flux.fromArray(fruits);
        StepVerifier.create(fruitFlux)
            .expectNext("Apple")
            .expectNext("Orange")
            .expectNext("Grape")
            .expectNext("Banana")
            .expectNext("Strawberry")
            .verifyComplete();
    }
}
