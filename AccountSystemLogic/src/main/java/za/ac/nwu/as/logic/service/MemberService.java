package za.ac.nwu.as.logic.service;

import org.springframework.stereotype.Service;
import za.ac.nwu.as.domain.dto.MemberDto;

import java.sql.SQLException;
import java.util.List;

@Service
public interface MemberService {
    MemberDto create(MemberDto memberDto) throws SQLException;

    List<MemberDto> getAllMembers() throws SQLException;

    MemberDto getMemberByID(Integer memberID) throws SQLException;
}
