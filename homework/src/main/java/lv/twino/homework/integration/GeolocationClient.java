package lv.twino.homework.integration;

import feign.Param;
import feign.RequestLine;
import lv.twino.homework.domain.dto.GeolocationPayload;

public interface GeolocationClient {

    @RequestLine("GET /{ip}")
    GeolocationPayload findByIp(@Param("ip") String ip);

}
