package za.ac.nwu.as.logic.service;

import java.sql.SQLException;

public interface UpdateAccountService {

    void updateBalanceByAccNum(Integer accountNumber, double amount) throws SQLException;
}
