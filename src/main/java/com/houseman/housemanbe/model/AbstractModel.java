package com.houseman.housemanbe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Abstract class for Data Transfer Object. Must be inherited from all Data
 * Transfer Object.
 *
 * @author Raduloff
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractModel implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 3727265298538872080L;

    @Transient
    private Integer currentPage;

    @Transient
    private List<String> sortColumns;

    @Transient
    private boolean sortAsc = true;

    @Transient
    private Integer pageSize;

    @Transient
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Transient
    public List<String> getSortColumns() {
        return sortColumns;
    }

    @Transient
    public void setSortColumns(List<String> sortColumns) {
        this.sortColumns = sortColumns;
    }

    @Transient
    public boolean isSortAsc() {
        return sortAsc;
    }

    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }

    @Transient
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
