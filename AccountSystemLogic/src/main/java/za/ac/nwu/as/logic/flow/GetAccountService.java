package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

public interface GetAccountService {
    List<AccountDto> getAllAccounts();

    AccountDto getAccountByMemID(Integer memberID);

    AccountDto getAccountNumByMemID(Integer memberID);

    AccountDto getAccountByAccNum(Integer accountNumber);

    AccountDto getAccountTypeByAccNum(Integer accountNumber);

    AccountDto getBalanceByAccNum(Integer accountNumber);

}
