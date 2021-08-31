package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.Member;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Account", description = "A DTO that represents the Account")
public class AccountDto implements Serializable {

    private Member memberID;
    private String type;
    private double balance;

    public AccountDto() {
    }

    public AccountDto(Member memberID, String type, double balance) {
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
    }

    public AccountDto(Account account)
    {
        this.setMemberID(account.getMemberID());
        this.setType(account.getType());
        this.setBalance(account.getBalance());
    }

    @ApiModelProperty(position = 1,
            value = "Account memberID",
            name = "memberID",
            notes = "Uniquely identifies the member of the account",
            dataType = "java.lang.Integer",
            example = "1",
            required = true)

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 2,
            value = "Account type",
            name = "type",
            notes = "Identifies the type of the account",
            dataType = "java.lang.String",
            example = "Miles",
            required = true)

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ApiModelProperty(position = 3,
            value = "Account balance",
            name = "balance",
            notes = "Provides the balance of the account",
            dataType = "java.lang.double",
            example = "250",
            required = true)

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Double.compare(that.balance, balance) == 0  && Objects.equals(memberID, that.memberID) && Objects.equals(type, that.type);
    }

    @JsonIgnore
    public Account getAccount(){
        return new Account(getMemberID(), getType(), getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, type, balance);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "memberID=" + memberID +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
