package org.aa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Map;

public class Puzz017_collectMap {
    public static void main(String[] args) {
        Flux<String> animalFlux = Flux.just(
            "aardvark", "elephant", "koala", "eagle", "kangaroo");
        Mono<Map<Character, String>> animalMapMono =
            animalFlux.collectMap(a -> a.charAt(0));
        StepVerifier
            .create(animalMapMono)
            .expectNextMatches(map -> {
                return
                    map.size() == 3 &&
                        map.get('a').equals("aardvark") &&
                        map.get('e').equals("eagle") &&
                        map.get('k').equals("kangaroo");
            })
            .verifyComplete();
    }
}
