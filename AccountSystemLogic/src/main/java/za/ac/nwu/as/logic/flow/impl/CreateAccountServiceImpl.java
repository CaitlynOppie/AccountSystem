package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.flow.CreateAccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountFlowName")
public class CreateAccountServiceImpl implements CreateAccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public CreateAccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        if(null == accountDto.getType()){
            accountDto.setType("Miles");
        }
        return accountTranslator.create(accountDto);
    }
}
