package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

    @Id
    @SequenceGenerator(name = "ACC_GENERIC_SEQ", sequenceName = "ACCOUNT.ACC_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_GENERIC_SEQ")
    @Column(name = "TRANSACTION_ID")
    private Long transactionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_NUMBER")
    private Account accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    private AccountType accountType;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "TRANSACTION_AMOUNT")
    private Long  transctionAmount;

    // Add or subtract
    @Column(name = "ACTION")
    private String action;

    @Column(name = "BALANCE")
    private Long balance;

    public Transaction(Long transactionID, Account accountNumber, AccountType accountType, LocalDate transactionDate, Long  transctionAmount, String action, Long  balance) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.transactionDate = transactionDate;
        this.transctionAmount = transctionAmount;
        this.action = action;
        this.balance = balance;
    }

    public Transaction() {
    }


    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountTypeID() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long  getTransctionAmount() {
        return transctionAmount;
    }

    public void setTransctionAmount(Long  transctionAmount) {
        this.transctionAmount = transctionAmount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long  balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(transctionAmount, that.transctionAmount) && Objects.equals(action, that.action) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountNumber, accountType, transactionDate, transctionAmount, action, balance);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", transactionDate=" + transactionDate +
                ", transctionAmount=" + transctionAmount +
                ", action='" + action + '\'' +
                ", balance=" + balance +
                '}';
    }
}
