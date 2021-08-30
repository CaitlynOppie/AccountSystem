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
    @SequenceGenerator(name = "ACC_GENERIC_SEQ", sequenceName = "ACCOUNT.ACC_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_GENERIC_SEQ")
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member memberID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    private AccountType accountTypeId;

    @Column(name = "BALANCE")
    private Long accountBalance;

    private Set<AccountTransaction> accountTransactions;

    public AccountType getAccountType() {
        return accountTypeId;
    }

    public void setAccountType(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Account(Long accountNumber, Member memberID, AccountType accountTypeId, Long accountBalance) {
        this.accountNumber = accountNumber;
        this.memberID = memberID;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public Account(Member memberID, AccountType accountTypeId, Long accountBalance) {
        this.memberID = memberID;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }


    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }


    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "transactionID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(memberID, account.memberID) && Objects.equals(accountTypeId, account.accountTypeId) && Objects.equals(accountBalance, account.accountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, memberID, accountTypeId, accountBalance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", memberID=" + memberID +
                ", accountTypeId=" + accountTypeId +
                ", accountBalance=" + accountBalance +
                '}';
    }
}




