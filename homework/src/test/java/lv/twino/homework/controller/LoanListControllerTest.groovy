package lv.twino.homework.controller

import lv.twino.homework.util.GsonConverter
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LoanListControllerTest extends Specification {

    def victim = LoanListController.getInstance()
    GsonConverter mockGsonConverter = Mock()

    def setup() {
        victim.setGsonConverter(mockGsonConverter)
    }

    def "Should get a list of loans: #result"() {

        setup:
        mockGsonConverter.convertToJson(_) >> result

        expect:
        victim.listApprovedLoans() == result

        where:
        result              | _
        '{"key":"value"}'   | _
        '{"key2":"value2"}' | _

    }

}
