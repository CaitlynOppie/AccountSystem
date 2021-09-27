package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.service.AccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Component("createAccountFlowName")
public class AccountServiceImpl implements AccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public AccountServiceImpl(AccountTranslator accountTranslator){
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

    @Override
    public List<AccountDto> getAllAccounts() throws SQLException {
        return accountTranslator.getAllAccounts();
    }

    @Override
    public double getBalanceByAccNum(Integer accountNumber) throws SQLException {
        return accountTranslator.getBalanceByAccNum(accountNumber);
    }

    @Override
    public AccountDto getByAccountNumber(Integer accountNumber) throws SQLException {
        return accountTranslator.getByAccountNumber(accountNumber);
    }

    @Override
    public void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException {
        accountTranslator.updateBalanceByAccNum(accountNumber, amount);
    }
}
