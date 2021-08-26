package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("/account-type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    //private final CreateAccountTypeFlow createAccountTypeFlow;

    //,
    //@Qualifier("createAccountTypeFlowName")
    //CreateAccountTypeFlow createAccountTypeFlow)

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow){
    this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    //this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<String>> getAll() {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<String> response = new GeneralResponse<>(true,"No types found");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PostMapping("")
//    @ApiOperation(value = "Creates new AccountType.", notes = "Creates a new AccountType in the DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
//            @ApiParam(value = "Request body to create a new AccountType.", required = true)
//            @RequestBody AccountTypeDto accountType) {
//    AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
//    GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
//    return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

//    @GetMapping("{mnemonic}")
//    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the AccountType corresponding to the given mnemonic")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//
//    public ResponseEntity<GeneralResponse<String>> getAccountType(
//            @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
//            example = "MILES",
//            name = "mnemonic",
//            required = true)
//            @PathVariable("mnemonic") final String mnemonic){
//        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
//        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
//        return new ResponseEntity<>(response, accountType);
//    }
}