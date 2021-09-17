package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.service.GetMemberService;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.sql.SQLException;
import java.util.List;

@Component
public class GetMemberServiceImpl implements GetMemberService {

    private final MemberTranslator memberTranslator;

    @Autowired
    public GetMemberServiceImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() throws SQLException {
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getMemberByID(Integer memberID) throws SQLException {
        return memberTranslator.getMemberByID(memberID);
    }


}
