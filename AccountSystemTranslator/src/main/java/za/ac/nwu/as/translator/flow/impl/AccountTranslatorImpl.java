package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.AccountRepository;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepository accountRepository;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/discovery", "root", "1234");

    @Autowired
    public AccountTranslatorImpl(AccountRepository accountRepository) throws SQLException {
        this.accountRepository = accountRepository;
        con.setAutoCommit(false);
    }

    @Override
    public List<za.ac.nwu.as.domain.dto.AccountDto> getAllAccounts() throws SQLException {

        try{
            List<za.ac.nwu.as.domain.dto.AccountDto> accountDtos = new ArrayList<>();
            for(Account account : accountRepository.findAll()){
                accountDtos.add(new za.ac.nwu.as.domain.dto.AccountDto(account));
            }
            con.commit();
            return accountDtos;

        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public za.ac.nwu.as.domain.dto.AccountDto create(AccountDto accountDto) throws SQLException {
        try{
            Account account = accountRepository.save(accountDto.getAccount());
            con.commit();
            return new za.ac.nwu.as.domain.dto.AccountDto(account);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public za.ac.nwu.as.domain.dto.AccountDto getByAccountNumber(Integer accountNumber) throws SQLException {
        try{
            Optional<Account> account = accountRepository.getByAccountNumber(accountNumber);
            con.commit();
            return new za.ac.nwu.as.domain.dto.AccountDto(account);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public za.ac.nwu.as.domain.dto.AccountDto getBalanceByAccNum(Integer accountNumber) throws SQLException {
        try{
            Account account = accountRepository.getBalanceByAccNum(accountNumber);
            con.commit();
            return new AccountDto(account);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException {
        try{
            Account account = accountRepository.getBalanceByAccNum(accountNumber);
            double balance = account.getBalance();
            if((amount < 0) && (Math.abs(amount) < balance)) {
                accountRepository.updateBalanceByAccNum(accountNumber, amount);
                con.commit();
            } else if(amount > 0){
                accountRepository.updateBalanceByAccNum(accountNumber, amount);
                con.commit();
            }
            else{
                throw new RuntimeException("Not enough in account");
            }
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to update the required balance", e);
        }
    }

}
