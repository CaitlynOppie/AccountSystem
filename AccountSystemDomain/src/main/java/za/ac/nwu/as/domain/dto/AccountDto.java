package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;

import javax.persistence.FetchType;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Account", description = "A DTO that represents the Account")
public class AccountDto implements Serializable {

    private Member memberID;
    private AccountType accountTypeId;
    private Long accountBalance;

    public AccountDto() {
    }

    public AccountDto(Member memberID, AccountType accountTypeId, Long accountBalance) {
        this.memberID = memberID;
        this.accountTypeId = accountTypeId;
        this.accountBalance = accountBalance;
    }

    public AccountDto(Account account){
        this.setMemberID(account.getMemberID());
        this.setAccountType(account.getAccountType());
        this.setAccountBalance(account.getAccountBalance());
    }

    @ApiModelProperty(position = 1,
        value = "Member_ID",
        name = "Member_ID",
        notes = "Uniquely identifies the member of the account",
        dataType = "Member",
        example = "0006090281087",
        required = true)

    public Member getMemberID(){return memberID;}
    public void setMemberID(Member memberID){this.memberID = memberID;}

    @ApiModelProperty(position = 1,
            value = "Account_Type",
            name = "Account_Type",
            notes = "Identifies the type of account",
            dataType = "Account",
            example = "Miles",
            required = true)

    public AccountType getAccountType(){return accountTypeId;}
    public void setAccountType(AccountType accountTypeId){this.accountTypeId = accountTypeId;}

    @ApiModelProperty(position = 3,
            value = "Account_Balance",
            name = "Account_Balance",
            notes = "Provides the current balance of the account",
            dataType = "java.lang.Long",
            example = "250",
            required = true)

    public Long getAccountBalance(){return accountBalance;}
    public void setAccountBalance(Long accountBalance){this.accountBalance = accountBalance;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(memberID, that.memberID) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountBalance, that.accountBalance);
    }

    @JsonIgnore
    public Account getAccount(){ return new Account(getMemberID(), getAccountType(), getAccountBalance());}

    @Override
    public int hashCode() {
        return Objects.hash(memberID, accountTypeId, accountBalance);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "memberID=" + memberID +
                ", accountTypeId=" + accountTypeId +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
