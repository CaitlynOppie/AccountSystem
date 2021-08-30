package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.MemberDto;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDto> getAllMembers();

    MemberDto getMemberByMemberID(Long memberID);
}
