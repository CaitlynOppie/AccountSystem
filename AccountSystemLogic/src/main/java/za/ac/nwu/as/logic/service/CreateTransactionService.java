package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.TransactionDto;

public interface CreateTransactionService {
    TransactionDto create(TransactionDto transactionDto);
}
