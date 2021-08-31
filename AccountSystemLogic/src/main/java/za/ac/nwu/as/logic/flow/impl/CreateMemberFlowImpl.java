package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.flow.CreateMemberFlow;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createMemberFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow {

    private final MemberTranslator memberTranslator;

    @Autowired
    public CreateMemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    // Create a new Member
    @Override
    public MemberDto create(MemberDto memberDto){
        if(null == memberDto.getMemFirstName()){
            memberDto.setMemFirstName("Caitlyn");
        }
        return memberTranslator.create(memberDto);
    }
}
