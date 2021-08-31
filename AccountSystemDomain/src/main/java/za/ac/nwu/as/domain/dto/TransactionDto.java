package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.Transaction;
import za.ac.nwu.as.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class TransactionDto implements Serializable {

    private Integer transactionID;
    private Member memberID;
    private Account accountNumber;
    private double amount;
    private LocalDate transactionDate;

    public TransactionDto() {
    }

    public TransactionDto(Integer transactionID, Member memberID, Account accountNumber, double amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.memberID = memberID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(Transaction transaction){
        this.setTransactionID(transaction.getTransactionID());
        this.setMemberID(transaction.getMemberID());
        this.setAccountNumber(transaction.getAccountNumber());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction transactionID",
            name = "transactionID",
            notes = "Uniquely identifies the transaction",
            dataType = "Integer",
            example = "1",
            required = true)

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
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
            dataType = "java.lang.Integer",
            example = "100",
            required = true)

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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


    @JsonIgnore
    public Transaction getTransaction(){return new Transaction(getTransactionID(), getMemberID(), getAccountNumber(), getAmount(), getTransactionDate() );}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(transactionID, that.transactionID) && Objects.equals(memberID, that.memberID) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, memberID, accountNumber, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "transactionID=" + transactionID +
                ", memberID=" + memberID +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
