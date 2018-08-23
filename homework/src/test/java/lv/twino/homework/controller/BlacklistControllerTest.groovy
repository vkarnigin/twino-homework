package lv.twino.homework.controller

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BlacklistControllerTest extends Specification {

    BlacklistControllerImpl victim = BlacklistControllerImpl.getInstance()

    def setup() {
        victim.setBlacklist(['123', '456'])
    }

    def "Should check if #personalId is blacklisted"() {

        expect:

        victim.isBlacklisted(personalId) == result

        where:

        personalId | result
        '123'      | true
        '456'      | true
        '789'      | false

    }

}
