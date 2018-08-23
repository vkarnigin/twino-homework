package lv.twino.homework.controller

import lv.twino.homework.domain.dto.GeolocationPayload
import lv.twino.homework.integration.GeolocationClient
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class GeolocationControllerTest extends Specification {

    GeolocationControllerImpl victim = GeolocationControllerImpl.getInstance()
    GeolocationClient mockGeolocationClient = Mock()

    def setup() {
        mockGeolocationClient.findByIp("123") >> createMockPayload("USA")
        mockGeolocationClient.findByIp("456") >> createMockPayload("GER")
        victim.setGeolocationClient(mockGeolocationClient)
    }

    def "Country code for IP #ip should be #code"() {

        expect:

        victim.getCountryCode(ip) == code

        where:

        ip    | code
        "123" | "USA"
        "456" | "GER"
        "789" | "LV"

    }

    private static GeolocationPayload createMockPayload(String code) {
        def payload = new GeolocationPayload()
        payload.setCountryCode(code)
        return payload
    }

}
