package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface GetTransactionService {
    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionByAccountNumber(Integer accountNumber);

    TransactionDto getTransactionByDate(LocalDate transactionDate);

}
