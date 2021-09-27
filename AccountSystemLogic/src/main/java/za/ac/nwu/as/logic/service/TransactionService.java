package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.TransactionDto;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {
    TransactionDto create(TransactionDto transactionDto) throws SQLException;

    List<TransactionDto> getAllTransactions() throws SQLException;

    List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws SQLException;

}
