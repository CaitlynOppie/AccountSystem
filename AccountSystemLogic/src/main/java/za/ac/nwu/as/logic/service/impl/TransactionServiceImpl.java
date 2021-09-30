package za.ac.nwu.as.logic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.service.TransactionService;
import za.ac.nwu.as.translator.flow.AccountTranslator;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Component("transactionServiceFlow")
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionTranslator transactionTranslator;
    private final AccountTranslator accountTranslator;

    public TransactionServiceImpl(TransactionTranslator transactionTranslator, AccountTranslator accountTranslator) {
        this.transactionTranslator = transactionTranslator;
        this.accountTranslator = accountTranslator;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) throws SQLException {
        LOGGER.info("The input object for this create method is {}", transactionDto);
        if(null == transactionDto.getTransactionDate()){
            transactionDto.setTransactionID(1);
            transactionDto.setAccountNumber(1);
            transactionDto.setAmount(100);
            transactionDto.setTransactionDate(LocalDate.now());
        }
        TransactionDto transaction = transactionDto.getTransactionDto();
        TransactionDto newTransaction = transactionTranslator.create(transaction);
        accountTranslator.updateBalanceByAccNum(transaction.getAccountNumber(), transaction.getAmount());
        TransactionDto newTrans = new TransactionDto(newTransaction);
        LOGGER.info("The return object for this create method is {}", newTrans);
        return newTrans;
    }

    @Override
    public List<TransactionDto> getAllTransactions() throws SQLException {
        List<TransactionDto> allTransactions = transactionTranslator.getAllTransactions();
        LOGGER.info("The return list is {}", allTransactions);
        return allTransactions;
    }

    @Override
    public List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws SQLException {
        LOGGER.info("The input is {}", accountNumber);
        List<TransactionDto> allTransactions = transactionTranslator.getTransactionByAccountNumber(accountNumber);
        LOGGER.info("The return list is {}", allTransactions);
        return allTransactions;
    }
}
