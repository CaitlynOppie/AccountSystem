package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.time.LocalDate;
import java.util.List;

public interface FetchTransactionFlow {
    List<TransactionDto> getAllTransactions();

    TransactionDto getTransactionByAccountNumber(Integer accountNumber);

    TransactionDto getTransactionByDate(LocalDate transactionDate);

    TransactionDto getTransactionByMemID(Integer memberID);

}
