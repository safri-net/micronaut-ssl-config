# Micronaut multiple SSL KeyStore configs cause error  

Having multiple services (client) configs with ssl keyStore (or trustStore) configs (as below).

```yaml
micronaut:        
  http:
    services:
      client1:
        urls:
          - https://localhost:8443
        ssl:
          enabled: true
          client-authentication: NEED
          keyStore:
            path: classpath:test/certs/client.p12
            password: secret
      client2:
        urls:
          - https://localhost:8443
        ssl:
          enabled: true
          client-authentication: NEED
          keyStore:
            path: classpath:test/certs/client2.p12
            password: secret
```

Causes following error:
```
Message: Multiple possible bean candidates found: [io.micronaut.http.client.ServiceHttpClientConfiguration$ServiceSslClientConfiguration$DefaultKeyStoreConfiguration, io.micronaut.http.client.ServiceHttpClientConfiguration$ServiceSslClientConfiguration$DefaultKeyStoreConfiguration]
Path Taken: new ServiceHttpClientConfiguration(String serviceId,ServiceConnectionPoolConfiguration connectionPoolConfiguration,[ServiceSslClientConfiguration sslConfiguration],ApplicationConfiguration applicationConfiguration)
io.micronaut.context.exceptions.BeanInstantiationException: Error instantiating bean of type  [io.micronaut.http.client.ServiceHttpClientConfiguration]
```
