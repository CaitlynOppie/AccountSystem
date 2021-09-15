package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;

import java.sql.SQLException;
import java.util.List;

@Component
public interface MemberTranslator {

    List<MemberDto> getAllMembers() throws SQLException;

    MemberDto create(MemberDto memberDto) throws SQLException;

    MemberDto getMemberByID(Integer memberID) throws SQLException;

}
