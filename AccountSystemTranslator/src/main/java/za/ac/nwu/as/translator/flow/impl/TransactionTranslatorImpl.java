package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.TransactionRepository;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.persistence.Transaction;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionTranslatorImpl implements TransactionTranslator {

    private final TransactionRepository transactionRepository;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/discovery", "root", "1234");

    @Autowired
    public TransactionTranslatorImpl(TransactionRepository transactionRepository) throws SQLException {
        this.transactionRepository = transactionRepository;
        con.setAutoCommit(false);
    }

    @Override
    public List<TransactionDto> getAllTransactions() throws SQLException {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        try{
            for(Transaction transaction : transactionRepository.findAll()){
                transactionDtos.add(new TransactionDto(transaction));
            }
            con.commit();
            return transactionDtos;
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) throws SQLException {
        try{
            Transaction transaction = transactionRepository.save(transactionDto.getTransaction());
            con.commit();
            return new TransactionDto(transaction);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public TransactionDto getTransactionByAccountNumber(Integer accountNumber) throws SQLException {
        try{
            Transaction transaction = transactionRepository.getTransactionByAccountNumber(accountNumber);
            con.commit();
            return new TransactionDto(transaction);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
