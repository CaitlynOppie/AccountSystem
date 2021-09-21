package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.persistence.Transaction;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Component
public interface TransactionTranslator {

    List<TransactionDto> getAllTransactions() throws SQLException;

    TransactionDto create(TransactionDto transactionDto) throws SQLException;

    List<TransactionDto> getTransactionByAccountNumber(Integer accountNumber) throws SQLException;
}
