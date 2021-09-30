package za.ac.nwu.as.logic.service;

import org.springframework.stereotype.Service;
import za.ac.nwu.as.domain.dto.AccountDto;

import java.sql.SQLException;
import java.util.List;

@Service
public interface AccountService {
    AccountDto create(AccountDto accountDto) throws SQLException;

    List<AccountDto> getAllAccounts() throws SQLException;

    double getBalanceByAccNum(Integer accountNumber) throws SQLException;

    AccountDto getByAccountNumber(Integer accountNumber) throws SQLException;

    void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException;
}
