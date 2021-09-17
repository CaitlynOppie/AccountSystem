package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.logic.service.UpdateAccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Transactional
@Component
public class UpdateAccountServiceImpl implements UpdateAccountService {

    private final AccountTranslator accountTranslator;

    @Autowired
    public UpdateAccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }


    @Override
    public void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException {
        accountTranslator.updateBalanceByAccNum(accountNumber, amount);
    }
}
