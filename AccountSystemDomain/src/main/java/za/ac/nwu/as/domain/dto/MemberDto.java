package za.ac.nwu.as.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.Member;

import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents the Member")
public class MemberDto {

    public String memFirstName;
    public String memLastName;
    public String memEmail;
    public String memPhone;

    public MemberDto() {
    }

    public MemberDto(String memFirstName, String memLastName, String memEmail, String memPhone) {
        this.memFirstName = memFirstName;
        this.memLastName = memLastName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
    }

    public MemberDto(Member member){
        this.setMemFirstName(member.getMemFirstName());
        this.setMemLastName(member.getMemLastName());
        this.setMemEmail(member.getMemEmail());
        this.setMemPhone(member.getMemPhone());
    }

    @ApiModelProperty(position = 1,
            value = "Member memFirstName",
            name = "MemFirstName",
            notes = "Identifies the name of the member",
            dataType = "java.lang.String",
            example = "Caitlyn",
            required = true)

    public String getMemFirstName() {
        return memFirstName;
    }

    public void setMemFirstName(String memFirstName) {
        this.memFirstName = memFirstName;
    }

    @ApiModelProperty(position = 2,
            value = "Member memLastName",
            name = "memLastName",
            notes = "Identifies the surname of the member",
            dataType = "java.lang.String",
            example = "Opperman",
            required = true)

    public String getMemLastName() {
        return memLastName;
    }

    public void setMemLastName(String memLastName) {
        this.memLastName = memLastName;
    }

    @ApiModelProperty(position = 3,
            value = "Member memEmail",
            name = "memEmail",
            notes = "Identifies the email of the member",
            dataType = "java.lang.String",
            example = "Caitlyn.Opperman@gmail.com",
            required = true)

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    @ApiModelProperty(position = 4,
            value = "Member memPhone",
            name = "memPhone",
            notes = "Identifies the phone number of the member",
            dataType = "java.lang.String",
            example = "071 245 7895",
            required = true)

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    @JsonIgnore
    public Member getMember(){return new Member(getMemFirstName(), getMemLastName(), getMemEmail(), getMemPhone());}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(memFirstName, memberDto.memFirstName) && Objects.equals(memLastName, memberDto.memLastName) && Objects.equals(memEmail, memberDto.memEmail) && Objects.equals(memPhone, memberDto.memPhone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(memFirstName, memLastName, memEmail, memPhone);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memFirstName='" + memFirstName + '\'' +
                ", memLastName='" + memLastName + '\'' +
                ", memEmail='" + memEmail + '\'' +
                ", memPhone='" + memPhone + '\'' +
                '}';
    }
}
