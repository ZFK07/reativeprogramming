package com.example.reactor.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {
        FluxAndMonoServices fluxAndMonoServices;
        @BeforeEach
         void  before(){
                fluxAndMonoServices = new FluxAndMonoServices();
        }

        @Test
        void test(){
                final Flux<String> stringFlux = fluxAndMonoServices.fruitsFlux();
                StepVerifier.create(stringFlux)
                        .expectNext("Mango","Orange","Banana").verifyComplete();
        }


        @Test
        void fruitsFlux() {
                final Flux<String> stringFlux = fluxAndMonoServices.fruitFluxCapital();
                StepVerifier.create(stringFlux)
                        .expectNext("MANGO","ORANGE","BANANA").verifyComplete();
        }

        @Test
        void fruitFluxCapital() {
        }

        @Test
        void fruitMono() {
        }

        @Test
        void main() {
        }

        @Test
        void countLettersInFlux() {
                final Flux<String> stringFlux = fluxAndMonoServices.countLettersInFlux();
                StepVerifier.create(stringFlux)
                        .expectNextCount(9).verifyComplete();

        }

        @Test
        void countLettersInFluxAsyn() {
                final Flux<String> stringFlux = fluxAndMonoServices.countLettersInFluxAsyn();
                StepVerifier.create(stringFlux)
                        .expectNextCount(9).verifyComplete();
        }
}