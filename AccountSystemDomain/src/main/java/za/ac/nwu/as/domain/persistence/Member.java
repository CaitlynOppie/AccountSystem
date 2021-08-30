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
    @SequenceGenerator(name = "ACC_GENERIC_SEQ", sequenceName = "ACCOUNT.ACC_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    private Long memID;

    @Column(name = "MEMBER_FIRST_NAME")
    private String memFirstName;

    @Column(name = "MEMBER_LAST_NAME")
    private String memLastName;

    @Column(name = "MEMBER_EMAIL")
    private String memEmail;

    @Column(name = "MEMBER_PHONE")
    private String memPhone;

    private Set<AccountTransaction> accountTransactions;
    private Set<Account> account;


    public Member(Long memID, String memFirstName, String memLastName, String memEmail, String memPhone) {
        this.memID = memID;
        this.memFirstName = memFirstName;
        this.memLastName = memLastName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
    }

    public Member() {
    }

    public Member(String memFirstName, String memLastName, String memEmail, String memPhone) {
        this.memFirstName = memFirstName;
        this.memLastName = memLastName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
    }

    public Long getMemID() {
        return memID;
    }

    public void setMemID(Long memID) {
        this.memID = memID;
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

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "transactionID", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
        this.accountTransactions = accountTransactions;
    }

    @OneToMany(targetEntity = Account.class, fetch = FetchType.LAZY, mappedBy = "memberID", orphanRemoval = true, cascade = CascadeType.PERSIST)
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
        return Objects.equals(memID, member.memID) && Objects.equals(memFirstName, member.memFirstName) && Objects.equals(memLastName, member.memLastName) && Objects.equals(memEmail, member.memEmail) && Objects.equals(memPhone, member.memPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memID, memFirstName, memLastName, memEmail, memPhone);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memID=" + memID +
                ", memFirstName='" + memFirstName + '\'' +
                ", memLastName='" + memLastName + '\'' +
                ", memEmail='" + memEmail + '\'' +
                ", memPhone='" + memPhone + '\'' +
                '}';
    }
}
