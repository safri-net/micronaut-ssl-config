package net.safri.micronaut

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class SslController {

    final Client1 client1

    SslController(Client1 client1) {
        this.client1 = client1
    }

    @Get
    HttpStatus test() {
        HttpStatus.OK
    }

    @Get("/call")
    HttpStatus call() {
        client1.test()
    }
}
