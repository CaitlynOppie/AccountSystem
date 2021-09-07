package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.AccountRepository;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountTranslatorImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAllAccounts(){

        try{
            List<AccountDto> accountDtos = new ArrayList<>();
            for(Account account : accountRepository.findAll()){
                accountDtos.add(new AccountDto(account));
            }
            return accountDtos;

        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        try{
            Account account = accountRepository.save(accountDto.getAccount());
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
            //rollback
        }
    }

    @Override
    public AccountDto getByAccountNumber(Integer accountNumber) {
        try{
            Optional<Account> account = accountRepository.getByAccountNumber(accountNumber);
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto getBalanceByAccNum(Integer accountNumber) {
        try{
            Account account = accountRepository.getBalanceByAccNum(accountNumber);
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void updateBalanceByAccNum(Integer accountNumber, double amount) {
        try{
            accountRepository.updateBalanceByAccNum(accountNumber,amount);
        }catch (Exception e){
            throw new RuntimeException("Unable to update the DB", e);
        }
    }

}
