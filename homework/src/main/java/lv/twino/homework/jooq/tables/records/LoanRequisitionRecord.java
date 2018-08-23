/*
 * This file is generated by jOOQ.
 */
package lv.twino.homework.jooq.tables.records;


import java.math.BigDecimal;
import java.sql.Date;

import javax.annotation.Generated;

import lv.twino.homework.jooq.tables.LoanRequisition;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LoanRequisitionRecord extends UpdatableRecordImpl<LoanRequisitionRecord> implements Record7<Integer, String, String, String, Date, BigDecimal, String> {

    private static final long serialVersionUID = -611099882;

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.ID</code>.
     */
    public LoanRequisitionRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.NAME</code>.
     */
    public LoanRequisitionRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.SURNAME</code>.
     */
    public LoanRequisitionRecord setSurname(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.SURNAME</code>.
     */
    public String getSurname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.PERSONAL_ID</code>.
     */
    public LoanRequisitionRecord setPersonalId(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.PERSONAL_ID</code>.
     */
    public String getPersonalId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.TERM</code>.
     */
    public LoanRequisitionRecord setTerm(Date value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.TERM</code>.
     */
    public Date getTerm() {
        return (Date) get(4);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.LOAN_AMOUNT</code>.
     */
    public LoanRequisitionRecord setLoanAmount(BigDecimal value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.LOAN_AMOUNT</code>.
     */
    public BigDecimal getLoanAmount() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>PUBLIC.LOAN_REQUISITION.COUNTRY_CODE</code>.
     */
    public LoanRequisitionRecord setCountryCode(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.LOAN_REQUISITION.COUNTRY_CODE</code>.
     */
    public String getCountryCode() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, Date, BigDecimal, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, String, Date, BigDecimal, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return LoanRequisition.LOAN_REQUISITION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return LoanRequisition.LOAN_REQUISITION.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return LoanRequisition.LOAN_REQUISITION.SURNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return LoanRequisition.LOAN_REQUISITION.PERSONAL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field5() {
        return LoanRequisition.LOAN_REQUISITION.TERM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field6() {
        return LoanRequisition.LOAN_REQUISITION.LOAN_AMOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return LoanRequisition.LOAN_REQUISITION.COUNTRY_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSurname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPersonalId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component5() {
        return getTerm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component6() {
        return getLoanAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getCountryCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSurname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPersonalId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value5() {
        return getTerm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value6() {
        return getLoanAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCountryCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value3(String value) {
        setSurname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value4(String value) {
        setPersonalId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value5(Date value) {
        setTerm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value6(BigDecimal value) {
        setLoanAmount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord value7(String value) {
        setCountryCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisitionRecord values(Integer value1, String value2, String value3, String value4, Date value5, BigDecimal value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LoanRequisitionRecord
     */
    public LoanRequisitionRecord() {
        super(LoanRequisition.LOAN_REQUISITION);
    }

    /**
     * Create a detached, initialised LoanRequisitionRecord
     */
    public LoanRequisitionRecord(Integer id, String name, String surname, String personalId, Date term, BigDecimal loanAmount, String countryCode) {
        super(LoanRequisition.LOAN_REQUISITION);

        set(0, id);
        set(1, name);
        set(2, surname);
        set(3, personalId);
        set(4, term);
        set(5, loanAmount);
        set(6, countryCode);
    }
}
