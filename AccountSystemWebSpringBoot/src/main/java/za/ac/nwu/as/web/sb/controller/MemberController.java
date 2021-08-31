package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.MemberDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateMemberFlow;
import za.ac.nwu.as.logic.flow.FetchMemberFlow;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final FetchMemberFlow fetchMemberFlow;
    private final CreateMemberFlow createMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow, CreateMemberFlow createMemberFlow) {
        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Members.", notes = "Returns a list of members")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Members returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll() {
        List<MemberDto> member = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Member.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value = "Request body to create a new Member.", required = true)
            @RequestBody MemberDto member) {
        MemberDto memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getMemberByID/{memberID}")
    @ApiOperation(value = "Fetches the specified Member using the member ID.", notes = "Fetches the Member corresponding to the given member ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Member returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getAccountByMemID(
            @ApiParam(value = "The member ID that identifies the Member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") Integer memberID){
        MemberDto member = fetchMemberFlow.getMemberByID(memberID);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getMemberByEmail/{memEmail}")
    @ApiOperation(value = "Fetches the specified Member using the email.", notes = "Fetches the Member corresponding to the given email")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Member returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getAccountByMemEmail(
            @ApiParam(value = "The member email that identifies the Member.",
                    example = "caitlyn.opperman@gmail.com",
                    name = "memEmail",
                    required = true)
            @PathVariable("memEmail") String memEmail){
        MemberDto member = fetchMemberFlow.getMemberByEmail(memEmail);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
