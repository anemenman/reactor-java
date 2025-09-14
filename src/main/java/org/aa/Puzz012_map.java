package org.aa;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Puzz012_map {
    public static void main(String[] args) {
        Flux<Player> playerFlux = Flux
            .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
            .map(n -> {
                String[] split = n.split("\\s");
                return new Player(split[0], split[1]);
            });
        StepVerifier.create(playerFlux)
            .expectNext(new Player("Michael", "Jordan"))
            .expectNext(new Player("Scottie", "Pippen"))
            .expectNext(new Player("Steve", "Kerr"))
            .verifyComplete();
    }

    @Data
    private static class Player {
        private final String firstName;
        private final String lastName;
    }
}