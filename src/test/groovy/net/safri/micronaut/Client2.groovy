package net.safri.micronaut

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("client2")
interface Client2 {
    @Get
    HttpStatus test()
}