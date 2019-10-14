package net.safri.micronaut

import io.micronaut.http.HttpStatus

import javax.inject.Singleton

@Singleton
class SSlService {
    final Client1 client1
    final Client2 client2

    SSlService(Client1 client1, Client2 client2) {
        this.client1 = client1
        this.client2 = client2
    }

    HttpStatus test1() {
        client1.test()
    }

    HttpStatus test2() {
        client2.test()
    }
}
