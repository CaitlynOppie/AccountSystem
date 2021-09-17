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
import za.ac.nwu.as.domain.service.Response;
import za.ac.nwu.as.logic.service.CreateMemberService;
import za.ac.nwu.as.logic.service.GetMemberService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final GetMemberService getMemberService;
    private final CreateMemberService createMemberService;

    @Autowired
    public MemberController(GetMemberService getMemberService, CreateMemberService createMemberService) {
        this.getMemberService = getMemberService;
        this.createMemberService = createMemberService;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Member.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Member was created successfully", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class)
    })
    public ResponseEntity<Response<MemberDto>> create(
            @ApiParam(value = "Request body to create a new Member.", required = true)
            @RequestBody MemberDto member) throws SQLException {
        MemberDto memberResponse = createMemberService.create(member);
        Response<MemberDto> response = new Response<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Members.", notes = "Returns a list of members")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Members returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)})

    public ResponseEntity<Response<List<MemberDto>>> getAll() throws SQLException {
        List<MemberDto> member = getMemberService.getAllMembers();
        Response<List<MemberDto>> response = new Response<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getMemberByID/{memberID}")
    @ApiOperation(value = "Fetches the specified Member using the member ID.", notes = "Fetches the Member corresponding to the given member ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Member returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)
    })
    public ResponseEntity<Response<MemberDto>> getAccountByMemID(
            @ApiParam(value = "The member ID that identifies the Member.",
                    example = "1",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") Integer memberID) throws SQLException {
        MemberDto member = getMemberService.getMemberByID(memberID);
        Response<MemberDto> response = new Response<>(true, member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
