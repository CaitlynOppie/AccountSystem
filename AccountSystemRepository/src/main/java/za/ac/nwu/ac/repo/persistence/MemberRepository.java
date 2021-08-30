package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistence.AccountType;
import za.ac.nwu.as.domain.persistence.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT" +
            " MEMBER_FIRST_NAME,"+
            "MEMBER_LAST_NAME," +
            " MEMBER_EMAIL,"+
            " MEMBER_PHONE"+
            "FROM" +
            "ACCOUNT.MEMBER" +
            "WHERE MMEMBER_ID = :memberID", nativeQuery = true)
    Member getMemberByMemberIDNativeQuery(Long memberID);
}
