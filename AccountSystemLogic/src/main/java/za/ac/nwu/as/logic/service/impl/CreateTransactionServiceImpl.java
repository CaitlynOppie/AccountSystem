package za.ac.nwu.as.logic.service.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.persistence.Transaction;
import za.ac.nwu.as.logic.service.CreateTransactionService;
import za.ac.nwu.as.translator.flow.AccountTranslator;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;

@Transactional
@Component("createATransactionFlowName")
public class CreateTransactionServiceImpl implements CreateTransactionService {

    private final TransactionTranslator transactionTranslator;
    private final AccountTranslator accountTranslator;

    public CreateTransactionServiceImpl(TransactionTranslator transactionTranslator, AccountTranslator accountTranslator) {
        this.transactionTranslator = transactionTranslator;
        this.accountTranslator = accountTranslator;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) throws SQLException {
        if(null == transactionDto.getTransactionDate()){
            transactionDto.setTransactionDate(LocalDate.now());
        }
        TransactionDto transaction = transactionDto.getTransactionDto();
        TransactionDto newTransaction = transactionTranslator.create(transaction);
        accountTranslator.updateBalanceByAccNum(transaction.getAccountNumber(), transaction.getAmount());
        //return transactionTranslator.create(transactionDto);
        return new TransactionDto(newTransaction);
    }
}
