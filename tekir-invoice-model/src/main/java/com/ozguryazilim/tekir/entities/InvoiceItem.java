/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author oyas
 */
@Entity
@Table(name = "TIV_INVOICE_ITEM")
public class InvoiceItem extends VoucherCommodityItemBase<Invoice>{
    
}
