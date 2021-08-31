package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.flow.CreateAccountFlow;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountFlowName")
public class CreateAccountFlowImpl implements CreateAccountFlow {

    private final AccountTranslator accountTranslator;

    @Autowired
    public CreateAccountFlowImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        if(null == accountDto.getAccountNumber()){
            accountDto.setAccountNumber(1);
        }
        return accountTranslator.create(accountDto);
    }
}
