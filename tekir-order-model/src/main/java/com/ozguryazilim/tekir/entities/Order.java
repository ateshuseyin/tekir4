/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Sipariş taban modeli.
 *
 * Alış ve satış siparişleri bu sınıftan türeyecekler
 *
 * @author Hakan Uygun
 */
@Entity
@Table(name = "TOR_ORDER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DIRECTION")
public class Order extends VoucherProcessBase{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "genericSeq")
    @Column(name = "ID")
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "PAYMENTPLAN_ID", foreignKey = @ForeignKey(name = "FK_ORD_PP"))
    private PaymentPlan paymentPlan;
    
    
    
    /**
     * Teslimat tarihi
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "SHIP_DATE")
    private Date shippingDate;
    
    @Column(name = "SHIP_NOTE")
    private String shippingNote;

    @Column(name = "TOT_CCY")
    private Currency currency;

    @Column(name = "TOT_AMT")
    private BigDecimal total = BigDecimal.ZERO;
    
    @Column(name = "LOCAL_AMOUNT")
    private BigDecimal localAmount = BigDecimal.ZERO;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderItem> items = new ArrayList<>();

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyColumn(name = "ROW_KEY")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, OrderSummary> summaries = new HashMap<>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Map<String, OrderSummary> getSummaries() {
        return summaries;
    }

    public void setSummaries(Map<String, OrderSummary> summaries) {
        this.summaries = summaries;
    }

    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public String getShippingNote() {
        return shippingNote;
    }

    public void setShippingNote(String shippingNote) {
        this.shippingNote = shippingNote;
    }

    public BigDecimal getLocalAmount() {
        return localAmount;
    }

    public void setLocalAmount(BigDecimal localAmount) {
        this.localAmount = localAmount;
    }
    
    
}
