package net.safri.micronaut

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("client1")
interface Client1 {
    @Get
    HttpStatus test()
}