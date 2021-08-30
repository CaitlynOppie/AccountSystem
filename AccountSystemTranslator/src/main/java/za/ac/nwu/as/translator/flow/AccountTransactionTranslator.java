package za.ac.nwu.as.translator.flow;

import za.ac.nwu.as.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto create(AccountTransactionDto accountDto);

    AccountTransactionDto getAccountTransactionByTransactionNumber(Long transactionNumber);

    AccountTransactionDto getAccountTransactionByTransactionNumberNativeQuery(Long transactionNumber);
}
