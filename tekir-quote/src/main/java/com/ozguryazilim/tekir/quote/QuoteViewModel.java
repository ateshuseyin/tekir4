package com.ozguryazilim.tekir.quote;

import com.ozguryazilim.tekir.entities.Contact;
import com.ozguryazilim.tekir.entities.Process;
import com.ozguryazilim.tekir.entities.VoucherGroup;
import com.ozguryazilim.tekir.entities.VoucherState;
import com.ozguryazilim.tekir.voucher.VoucherProcessViewModel;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

/**
 * View Model Class
 *
 * @author
 */
public class QuoteViewModel extends VoucherProcessViewModel{

    private BigDecimal total;
    private Currency currency;
    
    public QuoteViewModel(Long id, Process process, Contact account, List<String> tags, String voucherNo, String info, String referenceNo, Date date, String owner, VoucherState state, String stateReason, String stateInfo, VoucherGroup group, String topic, BigDecimal total, Currency currency) {
        super(id, process, account, tags, voucherNo, info, referenceNo, date, owner, state, stateReason, stateInfo, group, topic);
        this.total = total;
        this.currency = currency;
    }

    public QuoteViewModel(Long id, Long processId, String processNo, Long accountId, String accountName, Class<? extends Contact> accountType, List<String> tags, String voucherNo, String info, String referenceNo, Date date, String owner, VoucherState state, String stateReason, String stateInfo, Long groupId, String groupNo, String topic, BigDecimal total, Currency currency) {
        super(id, processId, processNo, accountId, accountName, accountType, tags, voucherNo, info, referenceNo, date, owner, state, stateReason, stateInfo, groupId, groupNo, topic);
        this.total = total;
        this.currency = currency;
    }
    
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    
    
}
