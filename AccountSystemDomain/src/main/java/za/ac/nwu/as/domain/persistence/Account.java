package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 7965908118439354885L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_NUMBER")
    private Integer accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member memberID;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "BALANCE")
    private double balance;

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "transactionID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<Transaction> transactions;

    public Account() {
    }

    public Account(Member memberID, String type, double balance) {
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
    }

    public Account(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(Integer accountNumber, Member memberID, String type, double balance) {
        this.accountNumber = accountNumber;
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
    }

    public Account(Integer accountNumber, Member memberID, String type, double balance, Set<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<Transaction> getAccountTransactions(){
        return transactions;
    }

    public void setAccountTransactions(Set<Transaction> transactions){
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(memberID, account.memberID) && Objects.equals(type, account.type) && Objects.equals(balance, account.balance) && Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, memberID, type, balance, transactions);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", memberID=" + memberID +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", accountTransactions=" + transactions +
                '}';
    }
}




