package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.MemberDto;

import java.sql.SQLException;

public interface CreateMemberService {
    MemberDto create(MemberDto memberDto) throws SQLException;
}
