package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.Transaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Transaction", description = "A DTO that represents the Transaction")
public class TransactionDto implements Serializable {

    private Integer transactionID;
    private AccountDto accountNumber;
    private double amount;
    private LocalDate transactionDate;

    public TransactionDto() {
    }

    public TransactionDto(Integer transactionID, AccountDto accountNumber, double amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(AccountDto accountNumber, double amount, LocalDate transactionDate) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(Transaction transaction){
        this.setTransactionID(transaction.getTransactionID());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
        if (null != transaction.getAccountNumber()){
            this.accountNumber = new AccountDto(transaction.getAccountNumber());
        }
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    @ApiModelProperty(position = 1,
            value = "Transaction Account_Number",
            name = "Account_Number",
            notes = "Uniquely identifies the account",
            dataType = "AccountDto",
            example = "1",
            required = true)

    public AccountDto getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountDto accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ApiModelProperty(position = 2,
            value = "Transaction Amount",
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

    @ApiModelProperty(position = 3,
            value = "Transaction Transaction_Date",
            name = "Transaction_Date",
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
    public Transaction getTransaction(){
        return new Transaction(
               getTransactionID(), getAccountNumber().getAccountNr(), getAmount(), getTransactionDate() );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionID=" + transactionID +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
