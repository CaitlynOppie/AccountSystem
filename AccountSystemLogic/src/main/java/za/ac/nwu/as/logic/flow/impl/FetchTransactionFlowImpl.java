package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.flow.FetchTransactionFlow;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.time.LocalDate;
import java.util.List;

@Component
public class FetchTransactionFlowImpl implements FetchTransactionFlow {

    private final TransactionTranslator transactionTranslator;

    @Autowired
    public FetchTransactionFlowImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionTranslator.getAllTransactions();
    }

    @Override
    public TransactionDto getTransactionByAccountNumber(Integer accountNumber) {
        return transactionTranslator.getTransactionByAccountNumber(accountNumber);
    }

    @Override
    public TransactionDto getTransactionByDate(LocalDate transactionDate) {
        return transactionTranslator.getTransactionByDate(transactionDate);
    }

    @Override
    public TransactionDto getTransactionByTransactionID(Integer transactionID) {
        return transactionTranslator.getTransactionByTransactionID(transactionID);
    }

    @Override
    public TransactionDto getTransactionByMemID(Integer memberID) {
        return transactionTranslator.getTransactionByMemID(memberID);
    }
}
