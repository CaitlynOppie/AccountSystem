package za.ac.nwu.as.logic.flow;

import za.ac.nwu.as.domain.dto.MemberDto;

public interface CreateMemberFlow {
    MemberDto create(MemberDto member);
}
