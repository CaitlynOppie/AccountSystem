package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {

    private static final long serialVersionUID = -5347390031256184618L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Integer memberID;

    @Column(name = "MEMBER_FIRST_NAME")
    private String memFirstName;

    @Column(name = "MEMBER_LAST_NAME")
    private String memLastName;

    @Column(name = "MEMBER_EMAIL")
    private String memEmail;

    @Column(name = "MEMBER_PHONE")
    private String memPhone;

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.LAZY, mappedBy = "transactionID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<Transaction> transactions;

    @OneToMany(targetEntity = Account.class, fetch = FetchType.LAZY, mappedBy = "accountNumber", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<Account> account;


    public Member() {
    }

    public Member(Integer memberID) {
        this.memberID = memberID;
    }

    public Member(Integer memberID, String memFirstName, String memLastName, String memEmail, String memPhone) {
        this.memberID = memberID;
        this.memFirstName = memFirstName;
        this.memLastName = memLastName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getMemFirstName() {
        return memFirstName;
    }

    public void setMemFirstName(String memFirstName) {
        this.memFirstName = memFirstName;
    }

    public String getMemLastName() {
        return memLastName;
    }

    public void setMemLastName(String memLastName) {
        this.memLastName = memLastName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public Set<Transaction> getAccountTransactions(){
        return transactions;
    }

    public void setAccountTransactions(Set<Transaction> transactions){
        this.transactions = transactions;
    }

    public Set<Account> getAccount(){
        return account;
    }

    public void setAccount(Set<Account> account){
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(memFirstName, member.memFirstName) && Objects.equals(memLastName, member.memLastName) && Objects.equals(memEmail, member.memEmail) && Objects.equals(memPhone, member.memPhone) && Objects.equals(transactions, member.transactions) && Objects.equals(account, member.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memFirstName, memLastName, memEmail, memPhone, transactions, account);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memFirstName='" + memFirstName + '\'' +
                ", memLastName='" + memLastName + '\'' +
                ", memEmail='" + memEmail + '\'' +
                ", memPhone='" + memPhone + '\'' +
                '}';
    }
}
