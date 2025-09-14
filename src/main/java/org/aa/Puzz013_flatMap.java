package org.aa;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class Puzz013_flatMap {
    public static void main(String[] args) {
        Flux<Player> playerFlux = Flux
            .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
            .flatMap(n -> Mono.just(n)
                .map(p -> {
                    String[] split = p.split("\\s");
                    return new Player(split[0], split[1]);
                })
                .subscribeOn(Schedulers.parallel())
            );
        List<Player> playerList = Arrays.asList(
            new Player("Michael", "Jordan"),
            new Player("Scottie", "Pippen"),
            new Player("Steve", "Kerr"));
        StepVerifier.create(playerFlux)
            .expectNextMatches(p -> playerList.contains(p))
            .expectNextMatches(p -> playerList.contains(p))
            .expectNextMatches(p -> playerList.contains(p))
            .verifyComplete();
    }

    @Data
    private static class Player {
        private final String firstName;
        private final String lastName;
    }
}
