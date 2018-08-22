package lv.twino.homework.controller;

import feign.Feign;
import feign.Request;
import feign.RetryableException;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import lv.twino.homework.integration.GeolocationClient;

import java.util.Optional;

public class GeolocationController {

    private static GeolocationClient geolocationClient;

    public static void init() {
        geolocationClient = Feign.builder()
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .options(new Request.Options(1000, 1000))
                .target(GeolocationClient.class, "http://ip-api.com/json");
    }

    public static Optional<String> getCountryCode(String ipAddress) {
        try {
            return Optional.ofNullable(geolocationClient.findByIp(ipAddress).getCountryCode());
        } catch (RetryableException e) {
            return Optional.empty();
        }
    }

}
