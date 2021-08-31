package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.TransactionRepository;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.persistence.Transaction;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionTranslator {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionTranslatorImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        try{
            for(Transaction transaction : transactionRepository.findAll()){
                transactionDtos.add(new TransactionDto(transaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return transactionDtos;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        try{
            Transaction transaction = transactionRepository.save(transactionDto.getTransaction());
            return new TransactionDto(transaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public TransactionDto getTransactionByAccountNumber(Integer accountNumber) {
        try{
            Transaction transaction = transactionRepository.getTransactionByAccountNumber(accountNumber);
            return new TransactionDto(transaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public TransactionDto getTransactionByDate(LocalDate transactionDate) {
        try{
            Transaction transaction = transactionRepository.getTransactionByDate(transactionDate);
            return new TransactionDto(transaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public TransactionDto getTransactionByMemID(Integer memberID) {
        try{
            Transaction transaction = transactionRepository.getTransactionByMemID(memberID);
            return new TransactionDto(transaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
