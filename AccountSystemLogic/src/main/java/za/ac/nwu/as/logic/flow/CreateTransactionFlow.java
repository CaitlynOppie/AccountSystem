package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.TransactionDto;

public interface CreateTransactionFlow {
    TransactionDto create(TransactionDto transactionDto);
}
