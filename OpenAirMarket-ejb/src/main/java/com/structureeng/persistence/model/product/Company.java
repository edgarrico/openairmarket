// Copyright 2013 Structure Eng Inc.

package com.structureeng.persistence.model.product;

import com.structureeng.persistence.history.HistoryListener;
import com.structureeng.persistence.history.Revision;
import com.structureeng.persistence.model.AbstractCatalogTenantModel;
import com.structureeng.persistence.model.history.product.CompanyHistory;

import com.google.common.base.Preconditions;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Define the different companies of a
 * {@code com.structureeng.persistence.model.product.ProductType}.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
@EntityListeners(value = {HistoryListener.class})
@Revision(builder = CompanyHistory.Builder.class)
@Entity
@Table(name = "company", uniqueConstraints = {
    @UniqueConstraint(name = "companyTenantPK", columnNames = {"idTenant", "idReference"}),
    @UniqueConstraint(name = "companyUK", columnNames = {"idTenant", "name"})})
public class Company extends AbstractCatalogTenantModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompany")
    private Long id;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyHistory> companyHistories;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = checkPositive(id);
    }

    public Set<CompanyHistory> getCompanyHistories() {
        return companyHistories;
    }

    public void setCompanyHistories(Set<CompanyHistory> companyHistories) {
        this.companyHistories = Preconditions.checkNotNull(companyHistories);
    }
    
    /**
     * Creates a new {@code Builder} instance.
     *
     * @return - new instance
     */
    public static Company.Buider newBuilder() {
        return new Company.Buider();
    }

    /**
     * Builder class that creates instances of {@code Company}.
     *
     * @author Edgar Rico (edgar.martinez.rico@gmail.com)
     */
    public static class Buider {

        private Integer referenceId;
        private String name;

        public Buider setReferenceId(Integer referenceId) {
            this.referenceId = Preconditions.checkNotNull(referenceId);
            return this;
        }

        public Buider setName(String name) {
            this.name = Preconditions.checkNotNull(name);
            return this;
        }

        /**
         * Creates a new instance of {@code Company}.
         *
         * @return - new instance
         */
        public Company build() {
            Company company = new Company();
            company.setReferenceId(referenceId);
            company.setName(name);
            return company;
        }
    }
}
