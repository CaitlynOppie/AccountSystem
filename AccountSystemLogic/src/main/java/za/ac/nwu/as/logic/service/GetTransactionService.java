package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.TransactionDto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface GetTransactionService {
    List<TransactionDto> getAllTransactions() throws SQLException;

    TransactionDto getTransactionByAccountNumber(Integer accountNumber) throws SQLException;

    TransactionDto getTransactionByDate(LocalDate transactionDate) throws SQLException;

}
