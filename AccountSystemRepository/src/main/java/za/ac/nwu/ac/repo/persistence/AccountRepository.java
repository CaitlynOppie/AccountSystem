package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT" +
            " ACCOUNT_NUMBER," +
            "MEMBER_ID,"+
            "ACCOUNT_TYPE_ID,"+
            "BALANCE" +
            "FROM" +
            "ACCOUNT.ACCOUNT" +
            "WHERE ACCOUNT_NUMBER = :accountNumber", nativeQuery = true)
    Account getAccountBalanceByAccountNumberNativeQuery(Long accountNumber);

    @Query(value = "SELECT" +
            " ACCOUNT_NUMBER," +
            "MEMBER_ID,"+
            "ACCOUNT_TYPE_ID,"+
            "BALANCE" +
            "FROM" +
            "ACCOUNT.ACCOUNT" +
            "WHERE MEMBER_ID = :memberID", nativeQuery = true)
    Account getAccountBalanceByMemberNativeQuery(Long memberID);

    @Query(value = "SELECT" +
            " ACCOUNT_NUMBER," +
            "MEMBER_ID,"+
            "ACCOUNT_TYPE_ID,"+
            "BALANCE" +
            "FROM" +
            "ACCOUNT.ACCOUNT" +
            "WHERE MEMBER_ID = :memberID AND ACCOUNT_TYPE_ID = :accountTypeID", nativeQuery = true)
    Account getAccountBalanceByMemberAndAccountTypeNativeQuery(Long memberID, Long accountTypeID);

    @Query(value = "UPDATE ACCOUNT.ACCOUNT set BALANCE = BALANCE + :amount WHERE MEMBER_ID = :memberID", nativeQuery = true)
    Account setAccountBalanceByMemberAndAmountNativeQuery(Long memberID, Long amount);

    // twee queries in een (insert into accountTransaction + today's date??)
    
    //Queries to do: insert new entry into accountTra

}

