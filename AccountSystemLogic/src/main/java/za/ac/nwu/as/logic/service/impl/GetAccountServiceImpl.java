package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.service.GetAccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.util.List;

@Component
public class GetAccountServiceImpl implements GetAccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public GetAccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountTranslator.getAllAccounts();
    }

    @Override
    public AccountDto getBalanceByAccNum(Integer accountNumber) {
        return accountTranslator.getBalanceByAccNum(accountNumber);
    }

    @Override
    public AccountDto getByAccountNumber(Integer accountNumber) {
        return accountTranslator.getByAccountNumber(accountNumber);
    }



}
