package lv.twino.homework.util

import lv.twino.homework.domain.dto.LoanRequisitionPayload
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class GsonConverterTest extends Specification {

    def victim = GsonConverterImpl.getInstance()

    def "Should convert #src to #dst"() {

        expect:

        victim.convertToJson(src) == dst

        where:

        src                | dst
        createMockObject() | createExpectedJson()

    }

    private static LoanRequisitionPayload createMockObject() {
        def result = new LoanRequisitionPayload()
        result.setName('Vasya')
        result.setSurname('Pupkin')
        result.setPersonalId('123')
        result.setLoanAmount(123.45)
        result.setTerm(new Date(2018, 8, 22))
        return result
    }

    private static String createExpectedJson() {
        return '{"name":"Vasya","surname":"Pupkin","personalId":"123","term":"22.09.3918","loanAmount":123.45}'
    }

}
