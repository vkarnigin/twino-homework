package lv.twino.homework.controller;

import feign.Feign;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.okhttp.OkHttpClient;
import lombok.Setter;
import lv.twino.homework.integration.GeolocationClient;

import java.util.Optional;

@Setter
public class GeolocationControllerImpl implements GeolocationController {

    private GeolocationClient geolocationClient;

    private GeolocationControllerImpl() {
        geolocationClient = Feign.builder()
                .client(new OkHttpClient())
                .decoder(new GsonDecoder())
                .options(new Request.Options(1000, 1000))
                .target(GeolocationClient.class, "http://ip-api.com/json");
    }
    private static class SingletonHolder {
        private static GeolocationController instance = new GeolocationControllerImpl();
    }

    public static GeolocationController getInstance() {
        return SingletonHolder.instance;
    }

    public String getCountryCode(String ipAddress) {
        try {
            Optional<String> optional = Optional.ofNullable(geolocationClient.findByIp(ipAddress).getCountryCode());
            return optional.orElse("LV");
        } catch (Exception e) {
            return "LV";
        }
    }

}
