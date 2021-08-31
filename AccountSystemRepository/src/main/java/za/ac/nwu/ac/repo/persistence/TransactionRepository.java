package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.Transaction;

import java.time.LocalDate;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //Get transaction by account number
    @Query(value = "SELECT t FROM Transaction t WHERE t.accountNumber = :accountNumberD")
    Transaction getTransactionByAccountNumber(Integer accountNumber);

    // Get transaction by date
    @Query(value = "SELECT t FROM Transaction t WHERE t.transactionDate = :transactionDate")
    Transaction getTransactionByDate(LocalDate transactionDate);

    // Get transaction by transaction ID
    @Query(value = "SELECT t FROM Transaction t WHERE t.transactionID = :transactionID")
    Transaction getTransactionByTransactionID(Integer transactionID);

    //Get transaction by memberID
    @Query(value = "SELECT t FROM Transaction t WHERE t.memberID = :memberID")
    Transaction getTransactionByMemID(Integer memberID);

    // Insert new transaction
    // --> use save from CrudRepository
}