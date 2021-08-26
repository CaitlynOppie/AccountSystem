package za.ac.nwu.as.translator.flow;

import java.util.List;

import za.ac.nwu.as.domain.dto.AccountTypeDto;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
