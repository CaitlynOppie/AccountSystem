package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT" +
    " ACCOUNT_TYPE_ID," +
    "ACCOUNT_NAME,"+
    "MNEMONIC" +
    "FROM" +
   "ACCOUNT.ACCOUNT_TYPE" +
    "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT" +
    " at" +
    "FROM" +
   "AccountType at" +
    "WHERE at.mnemonic = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonic(String mnemonic);

}
