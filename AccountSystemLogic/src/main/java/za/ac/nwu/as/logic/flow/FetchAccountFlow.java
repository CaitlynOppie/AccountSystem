package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

public interface FetchAccountFlow {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountByAccountNumber(Long accountNumber);
}
