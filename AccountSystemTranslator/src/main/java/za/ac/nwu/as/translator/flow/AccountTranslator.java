package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

@Component
public interface AccountTranslator {

    List<AccountDto> getAllAccounts();

    AccountDto getByAccountNumber(Integer accountNumber);

    AccountDto create(AccountDto accountDto);

    AccountDto getBalanceByAccNum(Integer accountNumber);

    void updateBalanceByAccNum(Integer accountNumber, double amount);
}
