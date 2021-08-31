package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.flow.FetchAccountFlow;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.util.List;

@Component
public class FetchAccountFlowImpl implements FetchAccountFlow {

    private final AccountTranslator accountTranslator;

    @Autowired
    public FetchAccountFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        return accountTranslator.getAllAccounts();
    }

    @Override
    public AccountDto getAccountByMemID(Integer memberID) {
        return accountTranslator.getAccountByMemID(memberID);
    }

    @Override
    public AccountDto getAccountNumByMemID(Integer memberID) {
        return accountTranslator.getAccountNumByMemID(memberID);
    }

    @Override
    public AccountDto getAccountByAccNum(Integer accountNumber) {
        return accountTranslator.getAccountByAccNum(accountNumber);
    }

    @Override
    public AccountDto getAccountTypeByAccNum(Integer accountNumber) {
        return accountTranslator.getAccountTypeByAccNum(accountNumber);
    }

    @Override
    public AccountDto getBalanceByAccNum(Integer accountNumber) {
        return accountTranslator.getBalanceByAccNum(accountNumber);
    }

}
