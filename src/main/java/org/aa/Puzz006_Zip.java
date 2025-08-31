package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

public class Puzz006_Zip {
    public static void main(String[] args) {
        Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa");
        Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples");
        Flux<Tuple2<String, String>> zippedFlux = Flux.zip(characterFlux, foodFlux);
        StepVerifier.create(zippedFlux)
            .expectNextMatches(p -> p.getT1().equals("Garfield") && p.getT2().equals("Lasagna"))
            .expectNextMatches(p -> p.getT1().equals("Kojak") && p.getT2().equals("Lollipops"))
            .expectNextMatches(p -> p.getT1().equals("Barbossa") && p.getT2().equals("Apples"))
            .verifyComplete();
    }
}
