package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.MemberDto;

import java.util.List;

public interface GetMemberService {

    List<MemberDto> getAllMembers();

    MemberDto getMemberByID(Integer memberID);

    MemberDto getMemberByEmail(String memEmail);

}
