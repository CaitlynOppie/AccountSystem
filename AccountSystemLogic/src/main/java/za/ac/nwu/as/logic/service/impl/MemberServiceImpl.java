package za.ac.nwu.as.logic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.logic.service.MemberService;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Component("memberServiceFlow")
public class MemberServiceImpl implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    private final MemberTranslator memberTranslator;

    @Autowired
    public MemberServiceImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    // Create a new Member
    @Override
    public MemberDto create(MemberDto memberDto) throws SQLException {
        LOGGER.info("The input object for this create method is {}", memberDto);
        if(null == memberDto.getMemFirstName()){
            memberDto.setMemberID(0);
            memberDto.setMemFirstName("Name");
            memberDto.setMemLastName("Surname");
            memberDto.setMemEmail("email@gmail.com");
            memberDto.setMemPhone("0000000000");
        }
        MemberDto result= memberTranslator.create(memberDto);
        LOGGER.info("The return object for this create method is {}", result);
        return result;
    }

    @Override
    public List<MemberDto> getAllMembers() throws SQLException {
        List<MemberDto> allMembers = memberTranslator.getAllMembers();
        LOGGER.info("The return list is {}", allMembers);
        return allMembers;
    }

    @Override
    public MemberDto getMemberByID(Integer memberID) throws SQLException {
        LOGGER.info("The input is {}", memberID);
        MemberDto member = memberTranslator.getMemberByID(memberID);
        LOGGER.info("The output is {}", member);
        return member;
    }
}
