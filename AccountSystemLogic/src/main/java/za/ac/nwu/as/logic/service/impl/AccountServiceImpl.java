package za.ac.nwu.as.logic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.logic.service.AccountService;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Component("accountServiceFlow")
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountTranslator accountTranslator;

    @Autowired
    public AccountServiceImpl(AccountTranslator accountTranslator){
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountDto create(AccountDto accountDto) throws SQLException {
        LOGGER.info("The input object for this create method is {}", accountDto);
        if(null == accountDto.getType()){
            accountDto.setAccountNumber(1);
            accountDto.setType("Miles");
            accountDto.setBalance(250);
        }
        AccountDto result = accountTranslator.create(accountDto);
        LOGGER.info("The return object for this create method is {}", result);
        return result;
    }

    @Override
    public List<AccountDto> getAllAccounts() throws SQLException {
        List<AccountDto> allAccounts = accountTranslator.getAllAccounts();
        LOGGER.info("The return list is {}", allAccounts);
        return allAccounts;
    }

    @Override
    public double getBalanceByAccNum(Integer accountNumber) throws SQLException {
        LOGGER.info("The input is {}", accountNumber);
        double balance = accountTranslator.getBalanceByAccNum(accountNumber);
        LOGGER.info("The output is {}", balance);
        return balance;
    }

    @Override
    public AccountDto getByAccountNumber(Integer accountNumber) throws SQLException {
        LOGGER.info("The input is {}", accountNumber);
        AccountDto account = accountTranslator.getByAccountNumber(accountNumber);
        LOGGER.info("The output object is {}", account);
        return account;
    }

    @Override
    public void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException {
        LOGGER.info("The input account number is {} and the amount is {}", accountNumber, amount);
        accountTranslator.updateBalanceByAccNum(accountNumber, amount);
    }
}
