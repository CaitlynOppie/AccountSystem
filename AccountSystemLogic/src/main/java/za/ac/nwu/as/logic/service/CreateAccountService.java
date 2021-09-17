package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.AccountDto;

import java.sql.SQLException;

public interface CreateAccountService {
    AccountDto create(AccountDto accountDto) throws SQLException;
}
