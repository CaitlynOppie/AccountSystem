package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.AccountTransaction;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;

import javax.persistence.FetchType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private AccountType accountType;
    private Member memberID;
    private Account accountNumber;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountType accountType, Member memberID, Account accountNumber, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberID = memberID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setAccountType(accountTransaction.getAccountTypeID());
        this.setMemberID(accountTransaction.getMemberID());
        this.setAccountNumber(accountTransaction.getAccountNumber());
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction Account_Type_ID",
            name = "Account_Type_ID",
            notes = "Uniquely identifies the account type",
            dataType = "Account_Type",
            example = "1",
            required = true)

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction Member_ID",
            name = "Member_ID",
            notes = "Uniquely identifies the member of the account",
            dataType = "Member",
            example = "0006090281087",
            required = true)

    public Member getMemberID() {
        return memberID;
    }

    public void setMemberID(Member memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Account_Number",
            name = "Account_Number",
            notes = "Uniquely identifies the account",
            dataType = "Account",
            example = "12345678",
            required = true)

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ApiModelProperty(position = 4,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "Provides the amount of the transaction",
            dataType = "java.lang.Long",
            example = "100",
            required = true)

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 5,
            value = "AccountTransaction Transaction_Date",
            name = "Traansaction_Date",
            notes = "Provide the date on which the transaction took place",
            dataType = "java.time.LocalDate",
            example = "2021-08-30",
            required = true)

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
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){return new AccountTransaction(getAccountType(), getMemberID(), getAccountNumber(), getAmount(), getTransactionDate() );}

    @Override
    public int hashCode() {
        return Objects.hash(accountType, memberID, accountNumber, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType +
                ", memberID=" + memberID +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
