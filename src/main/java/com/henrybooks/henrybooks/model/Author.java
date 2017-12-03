package com.henrybooks.henrybooks.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Author {
    private BigInteger authorNum;
    private String authorLast;
    private String authorFirst;

    @Id
    @Column(name = "authorNum")
    public BigInteger getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(BigInteger authorNum) {
        this.authorNum = authorNum;
    }

    @Basic
    @Column(name = "authorLast")
    public String getAuthorLast() {
        return authorLast;
    }

    public void setAuthorLast(String authorLast) {
        this.authorLast = authorLast;
    }

    @Basic
    @Column(name = "authorFirst")
    public String getAuthorFirst() {
        return authorFirst;
    }

    public void setAuthorFirst(String authorFirst) {
        this.authorFirst = authorFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorNum != null ? !authorNum.equals(author.authorNum) : author.authorNum != null) return false;
        if (authorLast != null ? !authorLast.equals(author.authorLast) : author.authorLast != null) return false;
        if (authorFirst != null ? !authorFirst.equals(author.authorFirst) : author.authorFirst != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorNum != null ? authorNum.hashCode() : 0;
        result = 31 * result + (authorLast != null ? authorLast.hashCode() : 0);
        result = 31 * result + (authorFirst != null ? authorFirst.hashCode() : 0);
        return result;
    }
}
