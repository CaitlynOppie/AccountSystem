package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")
public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -9071677108692950133L;
    private String mnemonic;
    private String accountTypeName;


    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountTypeName) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
    }
    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setMnemonic(accountType.getMnemonic());
    }

    @ApiModelProperty(position = 1,
    value = "AccountType Mnemonic",
    name = "Mnemonic",
    notes = "Uniquely identifies the account type",
    dataType = "java.lang.String",
    example = "MILES",
    required = true)

    public String getMnemonic() {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic){
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType Name",
            name = "Name",
            notes = "The name of the account type",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)

    public String getAccountTypeName() {
        return accountTypeName;
    }
    public void setAccountTypeName(String accountTypeName){
        this.accountTypeName = accountTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getMnemonic(), getAccountTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
