package lv.twino.homework.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanRequisitionPayload {

    String name;

    String surname;

    String personalId;

    Date term;

    BigDecimal loanAmount;

}
