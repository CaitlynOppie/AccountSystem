package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.logic.service.CreateAccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Transactional
@Component("createAccountFlowName")
public class CreateAccountServiceImpl implements CreateAccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public CreateAccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto) throws SQLException {
        if(null == accountDto.getType()){
            accountDto.setAccountNumber(1);
//            accountDto.setMemberID(new MemberDto(new Member(1,"Caitlyn", "Opperman", "ceopperman@gmail.coom", "0712437619")));
            accountDto.setType("Miles");
            accountDto.setBalance(250);
        }
        return accountTranslator.create(accountDto);
    }
}
