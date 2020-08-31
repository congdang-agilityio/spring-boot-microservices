package com.agility.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service") // Using the service name
@FeignClient(name="netflix-zuul-api-gateway-server") // Using the API Gateway
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
    String AUTH_TOKEN = "Authorization";
//    @GetMapping("/currency-exchange/from/{from}/to/{to}") // Using the service name
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // Using the API Gateway

    //Get the Bearer token from conversion service to pass to exchange service.
    public CurrencyConversionBean retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @RequestHeader(AUTH_TOKEN) String bearerToken
    );
}

