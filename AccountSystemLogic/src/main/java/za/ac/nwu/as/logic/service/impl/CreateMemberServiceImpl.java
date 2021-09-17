package za.ac.nwu.as.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.service.CreateMemberService;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Transactional
@Component("createMemberFlowName")
public class CreateMemberServiceImpl implements CreateMemberService {

    private final MemberTranslator memberTranslator;

    @Autowired
    public CreateMemberServiceImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    // Create a new Member
    @Override
    public MemberDto create(MemberDto memberDto) throws SQLException {
        if(null == memberDto.getMemFirstName()){
            memberDto.setMemberID(0);
            memberDto.setMemFirstName("Name");
            memberDto.setMemLastName("Surname");
            memberDto.setMemEmail("email@gmail.com");
            memberDto.setMemPhone("0000000000");
        }
        return memberTranslator.create(memberDto);
    }
}
