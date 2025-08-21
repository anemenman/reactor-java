package org.aa;

import reactor.core.publisher.Mono;

public class UppercaseApp {
    public static void main(String[] args) {
        Mono.just("Craig")
            .map(n -> n.toUpperCase())
            .map(cn -> "Hello, " + cn + "!")
            .subscribe(System.out::println);
    }
}
