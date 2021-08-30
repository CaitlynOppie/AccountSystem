package za.ac.nwu.as.translator.flow;

import za.ac.nwu.as.domain.dto.MemberDto;

import java.util.List;

public interface MemberTranslator {

    List<MemberDto> getAllMembers();

    MemberDto create(MemberDto member);

    MemberDto getMemberByMemberID(Long memberID);

    MemberDto getMemberByMemberIDNativeQuery(Long memberID);
}
