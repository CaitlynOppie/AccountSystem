package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

public interface GetAccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getBalanceByAccNum(Integer accountNumber);

    AccountDto getByAccountNumber(Integer accountNumber);

}
