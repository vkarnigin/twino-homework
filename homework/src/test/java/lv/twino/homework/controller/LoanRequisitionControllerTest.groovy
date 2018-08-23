package lv.twino.homework.controller

import lv.twino.homework.domain.dto.LoanRequisitionPayload
import lv.twino.homework.util.GsonConverter
import spark.Response
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LoanRequisitionControllerTest extends Specification {

    def victim = LoanRequisitionController.getInstance()
    BlacklistController mockBlacklistController = Mock()
    GeolocationController mockGeolocationController = Mock()
    GsonConverter mockGsonConverter = Mock()
    Response mockResponse = Mock()

    def setup() {
        victim.setBlacklistController(mockBlacklistController)
        victim.setGeolocationController(mockGeolocationController)
        victim.setGsonConverter(mockGsonConverter)
    }

    def "Should submit a loan requisition"() {
        setup:
        mockGeolocationController.getCountryCode("123") >> "SWE"
        mockGsonConverter.convertFromJson("", LoanRequisitionPayload.class) >> createMockPayload("Vasya", "Pupkin","007", 12.3)
        mockBlacklistController.isBlacklisted("007") >> false

        when:
        victim.requestLoan("", "123", mockResponse)

        then:
        1 * mockBlacklistController.isBlacklisted("007")
        1 * mockGeolocationController.getCountryCode("123")
    }

    private static LoanRequisitionPayload createMockPayload(String name, String surname, String personalId, BigDecimal loanAmount) {
        def payload = new LoanRequisitionPayload()
        payload.setName(name)
        payload.setSurname(surname)
        payload.setPersonalId(personalId)
        payload.setLoanAmount(loanAmount)
        payload.setTerm(new Date())
        return payload
    }

}
