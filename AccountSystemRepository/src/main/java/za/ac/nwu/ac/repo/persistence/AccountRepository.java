package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.Account;
import za.ac.nwu.as.domain.persistence.AccountTransaction;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
