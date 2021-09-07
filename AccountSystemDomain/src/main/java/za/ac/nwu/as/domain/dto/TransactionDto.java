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

@ApiModel(value = "Transaction", description = "A DTO that represents the Transaction")
public class TransactionDto implements Serializable {

    private Account accountNumber;
    private double amount;
    private LocalDate transactionDate;

    public TransactionDto() {
    }

    public TransactionDto(Account accountNumber, double amount, LocalDate transactionDate) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public TransactionDto(Transaction transaction){
        this.setAccountNumber(transaction.getAccountNumber());
        this.setAmount(transaction.getAmount());
        this.setTransactionDate(transaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "Transaction Account_Number",
            name = "Account_Number",
            notes = "Uniquely identifies the account",
            dataType = "Account",
            example = "1",
            required = true)

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
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
    public Transaction getTransaction(){return new Transaction(getAccountNumber(), getAmount(), getTransactionDate() );}

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
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
