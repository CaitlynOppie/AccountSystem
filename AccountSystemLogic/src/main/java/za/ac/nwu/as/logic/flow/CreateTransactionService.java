package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.TransactionDto;

public interface CreateTransactionService {
    TransactionDto create(TransactionDto transactionDto);
}
