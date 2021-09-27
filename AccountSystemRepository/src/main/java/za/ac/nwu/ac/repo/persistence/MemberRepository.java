package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // get member by ID
    @Query(value = "SELECT m FROM Member m WHERE m.memberID = :memberID")
    Member getMemberByID(Integer memberID);


}
