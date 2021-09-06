package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;

import java.util.List;

@Component
public interface AccountTranslator {

    List<AccountDto> getAllAccounts();

    AccountDto create(AccountDto accountDto);

    AccountDto getAccountByMemID(Integer memberID);

    AccountDto getBalanceByAccNum(Integer accountNumber, String type);
}
