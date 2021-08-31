package za.ac.nwu.as.translator.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.persistence.Member;
import za.ac.nwu.as.translator.flow.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try{
            for(Member account : memberRepository.findAll()){
                memberDtos.add(new MemberDto(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return memberDtos;
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        try{
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public MemberDto getMemberByID(Integer memberID) {
        try{
            Member member = memberRepository.getMemberByID(memberID);
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public MemberDto getMemberByEmail(String memEmail) {
        try{
            Member member = memberRepository.getMemberByEmail(memEmail);
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public MemberDto getMemberIDByEmail(String memEmail) {
        try{
            Member member = memberRepository.getMemberIDByEmail(memEmail);
            return new MemberDto(member);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
