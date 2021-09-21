package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.service.GetTransactionService;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
public class GetTransactionServiceImpl implements GetTransactionService {

    private final TransactionTranslator transactionTranslator;

    @Autowired
    public GetTransactionServiceImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public List<TransactionDto> getAllTransactions() throws SQLException {
        return transactionTranslator.getAllTransactions();
    }

    @Override
    public List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws SQLException {
        return transactionTranslator.getTransactionByAccountNumber(accountNumber);
    }

}
