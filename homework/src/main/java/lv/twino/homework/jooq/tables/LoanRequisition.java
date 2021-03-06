/*
 * This file is generated by jOOQ.
 */
package lv.twino.homework.jooq.tables;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import lv.twino.homework.jooq.Indexes;
import lv.twino.homework.jooq.Keys;
import lv.twino.homework.jooq.Public;
import lv.twino.homework.jooq.tables.records.LoanRequisitionRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class LoanRequisition extends TableImpl<LoanRequisitionRecord> {

    private static final long serialVersionUID = -1702507001;

    /**
     * The reference instance of <code>PUBLIC.LOAN_REQUISITION</code>
     */
    public static final LoanRequisition LOAN_REQUISITION = new LoanRequisition();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LoanRequisitionRecord> getRecordType() {
        return LoanRequisitionRecord.class;
    }

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.ID</code>.
     */
    public final TableField<LoanRequisitionRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.NAME</code>.
     */
    public final TableField<LoanRequisitionRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.SURNAME</code>.
     */
    public final TableField<LoanRequisitionRecord, String> SURNAME = createField("SURNAME", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.PERSONAL_ID</code>.
     */
    public final TableField<LoanRequisitionRecord, String> PERSONAL_ID = createField("PERSONAL_ID", org.jooq.impl.SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.TERM</code>.
     */
    public final TableField<LoanRequisitionRecord, Date> TERM = createField("TERM", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.LOAN_AMOUNT</code>.
     */
    public final TableField<LoanRequisitionRecord, BigDecimal> LOAN_AMOUNT = createField("LOAN_AMOUNT", org.jooq.impl.SQLDataType.DECIMAL, this, "");

    /**
     * The column <code>PUBLIC.LOAN_REQUISITION.COUNTRY_CODE</code>.
     */
    public final TableField<LoanRequisitionRecord, String> COUNTRY_CODE = createField("COUNTRY_CODE", org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    /**
     * Create a <code>PUBLIC.LOAN_REQUISITION</code> table reference
     */
    public LoanRequisition() {
        this(DSL.name("LOAN_REQUISITION"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.LOAN_REQUISITION</code> table reference
     */
    public LoanRequisition(String alias) {
        this(DSL.name(alias), LOAN_REQUISITION);
    }

    /**
     * Create an aliased <code>PUBLIC.LOAN_REQUISITION</code> table reference
     */
    public LoanRequisition(Name alias) {
        this(alias, LOAN_REQUISITION);
    }

    private LoanRequisition(Name alias, Table<LoanRequisitionRecord> aliased) {
        this(alias, aliased, null);
    }

    private LoanRequisition(Name alias, Table<LoanRequisitionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> LoanRequisition(Table<O> child, ForeignKey<O, LoanRequisitionRecord> key) {
        super(child, key, LOAN_REQUISITION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LoanRequisitionRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LOAN_REQUISITION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LoanRequisitionRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LoanRequisitionRecord>> getKeys() {
        return Arrays.<UniqueKey<LoanRequisitionRecord>>asList(Keys.CONSTRAINT_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisition as(String alias) {
        return new LoanRequisition(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoanRequisition as(Name alias) {
        return new LoanRequisition(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LoanRequisition rename(String name) {
        return new LoanRequisition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LoanRequisition rename(Name name) {
        return new LoanRequisition(name, null);
    }
}
