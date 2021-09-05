package za.ac.nwu.as.translator.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;

import java.util.List;

@Component
public interface MemberTranslator {

    List<MemberDto> getAllMembers();

    MemberDto create(MemberDto memberDto);

    MemberDto getMemberByID(Integer memberID);

//    MemberDto getMemberByEmail(String memEmail);

}
