package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.Account;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a where a.accountNumber = ?1")
    Optional<Account> getByAccountNumber(Integer accountNumber);

    //view balance of account
    @Query(value = "SELECT a.memberID, a.type, a.balance FROM Account a WHERE a.accountNumber = :accountNumber")
    Account getBalanceByAccNum(Integer accountNumber);

    //update balance (add & subtract)
    @Transactional
    @Modifying
    @Query(value = "UPDATE Account a SET a.balance = :amount + a.balance WHERE a.accountNumber = :accountNumber")
    void updateBalanceByAccNum(Integer accountNumber, double amount);


}

