package net.safri.micronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpStatus
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class SslConfigTest extends Specification {

    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run([
            "micronaut.server.ssl.key-store.path"                      : "classpath:test/certs/server.p12",
            "micronaut.server.ssl.key-store.password"                  : "secret",
            "micronaut.server.ssl.trust-store.path"                    : "classpath:test/certs/truststore",
            "micronaut.server.ssl.trust-store.password"                : "secret",
            "micronaut.http.services.client1.urls"                     : ["https://localhost:8443"],
            "micronaut.http.services.client1.ssl.enabled"              : true,
            "micronaut.http.services.client1.ssl.client-authentication": "NEED",
            "micronaut.http.services.client1.ssl.key-store.path"       : "classpath:test/certs/client1.p12",
            "micronaut.http.services.client1.ssl.key-store.password"   : "secret",
            "micronaut.http.services.client2.urls"                     : ["https://localhost:8443"],
            "micronaut.http.services.client2.ssl.enabled"              : true,
            "micronaut.http.services.client2.ssl.client-authentication": "NEED",
            "micronaut.http.services.client2.ssl.key-store.path"       : "classpath:test/certs/client2.p12",
            "micronaut.http.services.client2.ssl.key-store.password"   : "secret",


    ])

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ctx.getBean(EmbeddedServer).start()


    def "many services (clients) with ssl keystore configs"() {
        when:
        def s =ctx.getBean(SSlService)

        then:
        s.test1() == HttpStatus.OK
        s.test2() == HttpStatus.OK
    }
}
