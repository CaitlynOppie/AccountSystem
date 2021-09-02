package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.AccountRepository;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.translator.flow.AccountTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTranslatorImpl implements AccountTranslator {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountTranslatorImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAllAccounts(){
        List<AccountDto> accountDtos = new ArrayList<>();
        try{
            for(Account account : accountRepository.findAll()){
                accountDtos.add(new AccountDto(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountDtos;
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
    public AccountDto getAccountByMemID(Integer memberID) {
        try{
            Account account = accountRepository.getAccountByMemID(memberID);
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto getAccountNumByMemID(Integer memberID) {
        try{
            Account account = accountRepository.getAccountNumByMemID(memberID);
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto getAccountByAccNum(Integer accountNumber) {
        try{
            Account account = accountRepository.getAccountByAccNum(accountNumber);
            return new AccountDto(account);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountDto getAccountTypeByAccNum(Integer accountNumber) {
        try{
            Account account = accountRepository.getAccountTypeByAccNum(accountNumber);
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
}
