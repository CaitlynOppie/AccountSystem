package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/discovery", "root", "1234");

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) throws SQLException {
        this.memberRepository = memberRepository;
        con.setAutoCommit(false);
    }


    @Override
    public List<MemberDto> getAllMembers() throws SQLException {
        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for(Member member : memberRepository.findAll()){
                memberDtos.add(new MemberDto(member));
            }
            con.commit();
            return memberDtos;
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to get members from database", e);
        }
    }

    @Override
    public MemberDto create(MemberDto memberDto) throws SQLException {
        try{
            Member member = memberRepository.save(memberDto.getMember());
            con.commit();
            return new MemberDto(member);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to create new member", e);
        }
    }

    @Override
    public MemberDto getMemberByID(Integer memberID) throws SQLException {
        try{
            Member member = memberRepository.getMemberByID(memberID);
            con.commit();
            return new MemberDto(member);
        }catch (Exception e){
            con.rollback();
            throw new RuntimeException("Unable to get member details for member", e);
        }
    }
}
