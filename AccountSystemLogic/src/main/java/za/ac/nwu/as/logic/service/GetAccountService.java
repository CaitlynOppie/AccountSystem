package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.sql.SQLException;
import java.util.List;

public interface GetAccountService {
    List<AccountDto> getAllAccounts() throws SQLException;

    AccountDto getBalanceByAccNum(Integer accountNumber) throws SQLException;

    AccountDto getByAccountNumber(Integer accountNumber) throws SQLException;

}
