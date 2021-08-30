package za.ac.nwu.as.translator.flow;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

public interface AccountTranslator {

    List<AccountDto> getAllMAccounts();

    AccountDto create(AccountDto accountDto);

    AccountDto getAccountByAccountNumber(Long accountNumber);

    AccountDto getAccountByAccountNumberNativeQuery(Long accountNumber);
}
