/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.payment.sales;

import com.ozguryazilim.tekir.entities.BankCashAccount_;
import com.ozguryazilim.tekir.entities.Contact_;
import com.ozguryazilim.tekir.entities.PaymentReceived;
import com.ozguryazilim.tekir.entities.PaymentReceived_;
import com.ozguryazilim.tekir.entities.Process_;
import com.ozguryazilim.tekir.entities.VoucherBase_;
import com.ozguryazilim.tekir.entities.VoucherProcessBase_;
import com.ozguryazilim.tekir.voucher.VoucherBrowseBase;
import com.ozguryazilim.tekir.voucher.VoucherRepositoryBase;
import com.ozguryazilim.tekir.voucher.columns.VoucherStateColumn;
import com.ozguryazilim.telve.forms.Browse;
import com.ozguryazilim.telve.query.QueryDefinition;
import com.ozguryazilim.telve.query.columns.DateColumn;
import com.ozguryazilim.telve.query.columns.LinkColumn;
import com.ozguryazilim.telve.query.columns.MoneyColumn;
import com.ozguryazilim.telve.query.columns.SubTextColumn;
import com.ozguryazilim.telve.query.columns.TextColumn;
import com.ozguryazilim.telve.query.columns.UserColumn;
import com.ozguryazilim.telve.query.filters.BigDecimalFilter;
import com.ozguryazilim.telve.query.filters.DateFilter;
import com.ozguryazilim.telve.query.filters.DateValueType;
import com.ozguryazilim.telve.query.filters.FilterOperand;
import com.ozguryazilim.telve.query.filters.StringFilter;
import com.ozguryazilim.telve.query.filters.SubStringFilter;
import com.ozguryazilim.telve.query.filters.UserFilter;
import javax.inject.Inject;

/**
 *
 * @author oyas
 */
@Browse( feature=PaymentReceivedFeature.class)
public class PaymentReceivedBrowse extends VoucherBrowseBase<PaymentReceived, PaymentReceivedViewModel>{

    @Inject
    private PaymentReceivedRepository repository;
    
    @Override
    public VoucherRepositoryBase<PaymentReceived, PaymentReceivedViewModel> getVoucherRepository() {
        return repository;
    }

    @Override
    protected void buildQueryDefinition(QueryDefinition<PaymentReceived, PaymentReceivedViewModel> queryDefinition) {
        queryDefinition
                .addColumn(new LinkColumn<>(VoucherBase_.voucherNo, "voucher.label.VoucherNo"), true)
                .addColumn(new SubTextColumn<>(VoucherProcessBase_.account, Contact_.name, "voucher.label.Account"), true)
                .addColumn(new SubTextColumn<>(PaymentReceived_.bankCashAccount, BankCashAccount_.name, "bankCashAccount.label.Account"), true)
                .addColumn(new TextColumn<>(VoucherProcessBase_.topic, "voucher.label.Topic"), true)
                .addColumn(new DateColumn<>(VoucherBase_.date, "voucher.label.Date"), true)
                .addColumn(new MoneyColumn<>(PaymentReceived_.amount, PaymentReceived_.currency, "general.label.Total"), true)
                .addColumn(new UserColumn<>(VoucherBase_.owner, "voucher.label.Owner"), true)
                .addColumn(new TextColumn<>(VoucherBase_.referenceNo, "voucher.label.ReferenceNo"), false)
                .addColumn(new TextColumn<>(VoucherBase_.code, "voucher.label.Code"), false)
                .addColumn(new TextColumn<>(VoucherBase_.info, "voucher.label.Info"), false)
                .addColumn(new TextColumn<>(VoucherBase_.stateReason, "voucher.label.StateReason"), false)
                .addColumn(new TextColumn<>(VoucherBase_.stateInfo, "voucher.label.StateInfo"), false)
                .addColumn(new VoucherStateColumn<>( VoucherBase_.state, "general.label.State"), false)
                .addColumn(new SubTextColumn<>(VoucherProcessBase_.process, Process_.processNo, "voucher.label.Process"), false);
        
        queryDefinition
                .addFilter(new StringFilter<>(VoucherBase_.voucherNo, "voucher.label.VoucherNo"))
                .addFilter(new StringFilter<>(VoucherBase_.code, "voucher.label.Code"))
                .addFilter(new StringFilter<>(VoucherBase_.info, "voucher.label.Info"))
                .addFilter(new StringFilter<>(VoucherBase_.topic, "voucher.label.Topic"))
                .addFilter(new StringFilter<>(VoucherBase_.stateReason, "voucher.label.StateReason"))
                .addFilter(new UserFilter<>(VoucherBase_.owner, "voucher.label.Owner"))
                .addFilter(new BigDecimalFilter<>(PaymentReceived_.amount, "general.label.Total"))
                .addFilter(new SubStringFilter<>(VoucherProcessBase_.account, Contact_.name, "voucher.label.Account"))
                .addFilter(new SubStringFilter<>(PaymentReceived_.bankCashAccount, BankCashAccount_.name, "bankCashAccount.label.Account"))
                .addFilter(new SubStringFilter<>(VoucherProcessBase_.process, Process_.processNo, "voucher.label.Process"))
                .addFilter(new DateFilter<>(VoucherBase_.date, "voucher.label.Date", FilterOperand.In, DateValueType.LastTenDays));
    }
    
}