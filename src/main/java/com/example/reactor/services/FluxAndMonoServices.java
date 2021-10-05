package com.example.reactor.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxAndMonoServices {
        public Flux<String> fruitsFlux(){
                return Flux.fromIterable(List.of("Mango","Orange","Banana")).log();
        }

        public Flux<String> fruitFluxCapital(){
                return Flux.fromIterable(List.of("mango","orange","banana")).map(String::toUpperCase ).log();
        }

        public Flux<String> countLettersInFlux(){
                return Flux.fromIterable(List.of("Zahid","Khan")).flatMap(s -> Flux.just(s.split("")));
        }

        public Flux<String> countLettersInFluxAsyn(){
                return Flux.fromIterable(List.of("Zahid","Khan")).flatMap(s -> Flux.just(s.split(""))).delayElements(Duration.ofMillis(new Random().nextInt(1000))).log();
        }

        public Mono<String> fruitMono(){
                return Mono.just("Mango").log();
        }



        public static void main(String[] args) {
                FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
                fluxAndMonoServices.fruitsFlux().subscribe(System.out::println);

                fluxAndMonoServices.fruitMono().subscribe(System.out::println);
        }
}
