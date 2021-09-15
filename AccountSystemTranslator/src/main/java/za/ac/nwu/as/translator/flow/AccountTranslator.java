package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;

import java.sql.SQLException;
import java.util.List;

@Component
public interface AccountTranslator {

    List<AccountDto> getAllAccounts() throws SQLException;

    AccountDto getByAccountNumber(Integer accountNumber) throws SQLException;

    AccountDto create(AccountDto accountDto) throws SQLException;

    AccountDto getBalanceByAccNum(Integer accountNumber) throws SQLException;

    void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException;
}
