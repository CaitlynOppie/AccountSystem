package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateAccountService;
import za.ac.nwu.as.logic.flow.GetAccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final GetAccountService getAccountService;
    private final CreateAccountService createAccountService;

    @Autowired
    public AccountController(GetAccountService getAccountService, CreateAccountService createAccountService) {
        this.getAccountService = getAccountService;
        this.createAccountService = createAccountService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Accounts.", notes = "Returns a list of accounts")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Accounts returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountDto>>> getAll() {
    List<AccountDto> account = getAccountService.getAllAccounts();
    GeneralResponse<List<AccountDto>> response = new GeneralResponse<>(true,account);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Account.", notes = "Creates a new Account in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Account was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> create(
            @ApiParam(value = "Request body to create a new Account.", required = true)
            @RequestBody AccountDto account) {
    AccountDto accountResponse = createAccountService.create(account);
    GeneralResponse<AccountDto> response = new GeneralResponse<>(true, accountResponse);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAccountByMemID/{memberID}")
    @ApiOperation(value = "Fetches the specified Account using the member ID.", notes = "Fetches the Account corresponding to the given member ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getAccountByMemID(
            @ApiParam(value = "The member ID that identifies the Account.",
            example = "9",
            name = "memberID",
            required = true)
            @PathVariable("memberID") Integer memberID){
        AccountDto account = getAccountService.getAccountByMemID(memberID);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAccountTypeByMemID/{memberID}")
    @ApiOperation(value = "Fetches the specified Account Number using the memberID.", notes = "Fetches the Account number corresponding to the given member ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getAccountNumByMemID(
            @ApiParam(value = "The member ID that identifies the Account.",
                    example = "9",
                    name = "memberID",
                    required = true)
            @PathVariable("memberID") Integer memberID){
        AccountDto account = getAccountService.getAccountNumByMemID(memberID);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAccountByAccNum/{accountNumber}")
    @ApiOperation(value = "Fetches the specified Account using the Account Number.", notes = "Fetches the Account corresponding to the given account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account Number returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getAccountByAccNum(
            @ApiParam(value = "The accountNumber that identifies the Account.",
                    example = "123456789",
                    name = "accountNumber",
                    required = true)
            @PathVariable("accountNumber") Integer accountNumber){
        AccountDto account = getAccountService.getAccountByAccNum(accountNumber);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAccountTypeByAccNum/{accountNumber}")
    @ApiOperation(value = "Fetches the specified Account Type using the Account Number.", notes = "Fetches the Account Type corresponding to the given account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account Type returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getAccountTypeByAccNum(
            @ApiParam(value = "The accountNumber that identifies the Account.",
                    example = "123456789",
                    name = "accountNumber",
                    required = true)
            @PathVariable("accountNumber") Integer accountNumber){
        AccountDto account = getAccountService.getAccountTypeByAccNum(accountNumber);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getBalanceByAccNum/{accountNumber}")
    @ApiOperation(value = "Fetches the balance of the account using the Account Number.", notes = "Fetches the balance of the account corresponding to the given account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account Type returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountDto>> getBalanceByAccNum(
            @ApiParam(value = "The accountNumber that identifies the Account.",
                    example = "123456789",
                    name = "accountNumber",
                    required = true)
            @PathVariable("accountNumber") Integer accountNumber){
        AccountDto account = getAccountService.getBalanceByAccNum(accountNumber);
        GeneralResponse<AccountDto> response = new GeneralResponse<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
