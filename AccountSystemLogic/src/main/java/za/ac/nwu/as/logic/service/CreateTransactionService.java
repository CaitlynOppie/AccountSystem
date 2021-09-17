package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.TransactionDto;

import java.sql.SQLException;

public interface CreateTransactionService {
    TransactionDto create(TransactionDto transactionDto) throws SQLException;
}
