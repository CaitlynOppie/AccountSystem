package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.service.GetAccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.sql.SQLException;
import java.util.List;

@Component
public class GetAccountServiceImpl implements GetAccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public GetAccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public List<AccountDto> getAllAccounts() throws SQLException {
        return accountTranslator.getAllAccounts();
    }

    @Override
    public AccountDto getBalanceByAccNum(Integer accountNumber) throws SQLException {
        return accountTranslator.getBalanceByAccNum(accountNumber);
    }

    @Override
    public AccountDto getByAccountNumber(Integer accountNumber) throws SQLException {
        return accountTranslator.getByAccountNumber(accountNumber);
    }



}
