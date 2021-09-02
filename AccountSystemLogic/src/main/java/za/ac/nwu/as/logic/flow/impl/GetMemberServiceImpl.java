package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.flow.GetMemberService;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.util.List;

@Component
public class GetMemberServiceImpl implements GetMemberService {

    private final MemberTranslator memberTranslator;

    @Autowired
    public GetMemberServiceImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers(){
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getMemberByID(Integer memberID) {
        return memberTranslator.getMemberByID(memberID);
    }

    @Override
    public MemberDto getMemberByEmail(String memEmail) {
        return memberTranslator.getMemberByEmail(memEmail);
    }

}
