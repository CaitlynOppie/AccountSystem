package za.ac.nwu.as.logic.service;

import za.ac.nwu.as.domain.dto.MemberDto;

import java.sql.SQLException;
import java.util.List;

public interface GetMemberService {

    List<MemberDto> getAllMembers() throws SQLException;

    MemberDto getMemberByID(Integer memberID) throws SQLException;

//    MemberDto getMemberByEmail(String memEmail);

}
