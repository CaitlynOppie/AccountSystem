package za.ac.nwu.as.logic.service.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.service.TransactionService;
import za.ac.nwu.as.translator.flow.AccountTranslator;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Component("createATransactionFlowName")
public class TransactionServiceImpl implements TransactionService {

    private final TransactionTranslator transactionTranslator;
    private final AccountTranslator accountTranslator;

    public TransactionServiceImpl(TransactionTranslator transactionTranslator, AccountTranslator accountTranslator) {
        this.transactionTranslator = transactionTranslator;
        this.accountTranslator = accountTranslator;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) throws SQLException {
        if(null == transactionDto.getTransactionDate()){
            transactionDto.setTransactionID(1);
            transactionDto.setAccountNumber(1);
            transactionDto.setAmount(100);
            transactionDto.setTransactionDate(LocalDate.now());
        }
        TransactionDto transaction = transactionDto.getTransactionDto();
        TransactionDto newTransaction = transactionTranslator.create(transaction);
        accountTranslator.updateBalanceByAccNum(transaction.getAccountNumber(), transaction.getAmount());
        return new TransactionDto(newTransaction);
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
