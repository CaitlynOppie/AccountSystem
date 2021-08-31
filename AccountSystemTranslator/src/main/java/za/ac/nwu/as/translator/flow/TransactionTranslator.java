package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

@Component
public interface TransactionTranslator {

    List<TransactionDto> getAllTransactions();

    TransactionDto create(TransactionDto transactionDto);

    TransactionDto getTransactionByAccountNumber(Integer accountNumber);

    TransactionDto getTransactionByDate(LocalDate transactionDate);

    TransactionDto getTransactionByTransactionID(Integer transactionID);

    TransactionDto getTransactionByMemID(Integer memberID);
}
