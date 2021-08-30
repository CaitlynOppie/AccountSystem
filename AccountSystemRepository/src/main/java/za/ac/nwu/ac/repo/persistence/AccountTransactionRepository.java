package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT" +
            "TRANSACTION_ID," +
            "ACCOUNT_TYPE_ID,"+
            "MEMBER_ID,"+
            "AMOUNT," +
            "TRANSACTION_DATE,"+
            "ACCOUNT_NUMBER"+
            "FROM" +
            "ACCOUNT.ACCOUNT_TRANSACTION" +
            "WHERE MEMBER_ID = :memberID", nativeQuery = true)
    AccountTransaction getAccountTransactionByMemberNativeQuery(Long memberID);

    @Query(value = "SELECT" +
            "TRANSACTION_ID," +
            "ACCOUNT_TYPE_ID,"+
            "MEMBER_ID,"+
            "AMOUNT," +
            "TRANSACTION_DATE,"+
            "ACCOUNT_NUMBER"+
            "FROM" +
            "ACCOUNT.ACCOUNT_TRANSACTION" +
            "WHERE ACCOUNT_TYPE_ID = :accountTypeID", nativeQuery = true)
    AccountTransaction getAccountTransactionByAccountTypeNativeQuery(Long accountTypeID);
}
