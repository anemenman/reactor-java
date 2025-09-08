package org.aa;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Puzz010_filter {
    public static void main(String[] args) {
        Flux<String> nationalParkFlux = Flux.just(
                "Yellowstone", "Yosemite", "Grand Canyon", "Zion", "Grand Teton")
            .filter(np -> !np.contains(" "));
        StepVerifier.create(nationalParkFlux)
            .expectNext("Yellowstone", "Yosemite", "Zion")
            .verifyComplete();
    }
}
