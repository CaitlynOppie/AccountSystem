package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    // get account by member ID
    @Query(value = "SELECT a FROM Account a WHERE a.memberID = :memberID")
    Account getAccountByMemID(Integer memberID);
//
//    // get account number by member ID
//    @Query(value = "SELECT a.accountNumber FROM Account a WHERE a.memberID = :memberID")
//    Account getAccountNumByMemID(Integer memberID);
//
//    // get account by account number
//    @Query(value = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
//    Account getAccountByAccNum(Integer accountNumber);
//
//    // get account type by account number
//    @Query(value = "SELECT a.type FROM Account a WHERE a.accountNumber = :accountNumber")
//    Account getAccountTypeByAccNum(Integer accountNumber);

    //view balance of account
    @Query(value = "SELECT a.balance FROM Account a WHERE a.accountNumber = :accountNumber")
    Account getBalanceByAccNum(Integer accountNumber);

    //update balance (add & subtract)
    @Query(value = "UPDATE Account a SET a.balance = :amount + a.balance WHERE a.accountNumber = :accountNumber")
    Account setBalanceByAccNum(Integer accountNumber, double amount);


}

