package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.AccountDto;

public interface CreateAccountFlow {
    AccountDto create(AccountDto accountDto);
}
