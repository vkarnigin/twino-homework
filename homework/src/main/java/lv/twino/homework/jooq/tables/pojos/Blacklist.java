/*
 * This file is generated by jOOQ.
 */
package lv.twino.homework.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Blacklist implements Serializable {

    private static final long serialVersionUID = -1571773627;

    private final String personalId;

    public Blacklist(Blacklist value) {
        this.personalId = value.personalId;
    }

    public Blacklist(
        String personalId
    ) {
        this.personalId = personalId;
    }

    public String getPersonalId() {
        return this.personalId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Blacklist (");

        sb.append(personalId);

        sb.append(")");
        return sb.toString();
    }
}
