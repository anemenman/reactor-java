package org.aa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class Puzz016_collectList {
    public static void main(String[] args) {
        Flux<String> fruitFlux = Flux.just(
            "apple", "orange", "banana", "kiwi", "strawberry");
        Mono<List<String>> fruitListMono = fruitFlux.collectList();
        StepVerifier
            .create(fruitListMono)
            .expectNext(Arrays.asList(
                "apple", "orange", "banana", "kiwi", "strawberry"))
            .verifyComplete();
    }
}
