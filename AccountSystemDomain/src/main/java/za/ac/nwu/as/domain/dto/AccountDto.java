package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@ApiModel(value = "Account", description = "A DTO that represents the Account")
public class AccountDto implements Serializable {

    private Integer accountNumber;
    private Integer memberID;
//    private MemberDto memberID;
    private String type;
    private double balance;

    public AccountDto() {
    }

    public AccountDto(Integer accountNumber, Integer memberID, String type, double balance) {
        this.accountNumber = accountNumber;
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
    }

    public AccountDto(Integer memberID, String type, double balance) {
        this.memberID = memberID;
        this.type = type;
        this.balance = balance;
    }


    public AccountDto(AccountDto accountDto)
    {
        this.setAccountNumber(accountDto.getAccountNumber());
        this.setType(accountDto.getType());
        this.setBalance(accountDto.getBalance());
        if (null != accountDto.getMemberID()){
            this.memberID = accountDto.getMemberID();
        }
    }

    public AccountDto(Account account)
    {
        this.setAccountNumber(account.getAccountNumber());
        this.setType(account.getType());
        this.setBalance(account.getBalance());
        if (null != account.getMemberID()){
            this.memberID = account.getMemberID().getMemberID();
        }
    }

    public Integer getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ApiModelProperty(position = 1,
            value = "Account memberID",
            name = "memberID",
            notes = "Uniquely identifies the member of the account",
            dataType = "MemberDto",
            example = "1",
            required = true)

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 2,
            value = "Account type",
            name = "type",
            notes = "Identifies the type of the account",
            dataType = "java.lang.String",
            example = "MILES",
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
        return Double.compare(that.balance, balance) == 0 && Objects.equals(memberID, that.memberID) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, type, balance);
    }

    @JsonIgnore
    public Account getAccount(){
        return new Account(getAccountNumber(), getMemberID(), getType(), getBalance());
    }

    @JsonIgnore
    public Account getAccountNr(){
        return new Account(getAccountNumber());
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountNumber=" + accountNumber +
                ", memberID=" + memberID +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
