package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

    private static final long serialVersionUID = -6665887695940110048L;
    @Id
    @SequenceGenerator(name = "DIS_GENERIC_SEQ", sequenceName = "DISCOVERY.DIS_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIS_GENERIC_SEQ")
    @Column(name = "TRANSACTION_ID")
    private Integer transactionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member memberID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_NUMBER")
    private Account accountNumber;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    public Transaction() {
    }

    public Transaction(Integer transactionID, Member memberID, Account accountNumber, Double amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.memberID = memberID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(memberID, that.memberID) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, memberID, accountNumber, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", memberID=" + memberID +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
