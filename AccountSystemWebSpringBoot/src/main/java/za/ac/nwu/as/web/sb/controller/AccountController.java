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
import za.ac.nwu.as.domain.service.Response;
import za.ac.nwu.as.logic.service.AccountService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Account.", notes = "Creates a new Account in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Account was created successfully", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class)
    })
    public ResponseEntity<Response<AccountDto>> create(
            @ApiParam(value = "Request body to create a new Account.", required = true)
            @RequestBody AccountDto account) throws SQLException {
        AccountDto accountResponse = accountService.create(account);
        Response<AccountDto> response = new Response<>(true, accountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Accounts.", notes = "Returns a list of accounts")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Accounts returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)})

    public ResponseEntity<Response<List<AccountDto>>> getAll() throws SQLException {
    List<AccountDto> account = accountService.getAllAccounts();
    Response<List<AccountDto>> response = new Response<>(true,account);
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getBalanceByAccNum/{accountNumber}")
    @ApiOperation(value = "Fetches the balance of the account using the Account Number.",
            notes = "Fetches the balance of the account corresponding to the given account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account Type returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)
    })
    public ResponseEntity<Response<Double>> getBalanceByAccNum(
            @ApiParam(value = "The accountNumber that identifies the Account.",
                    example = "1",
                    name = "accountNumber",
                    required = true)
            @PathVariable("accountNumber") Integer accountNumber) throws SQLException {
        double balance = accountService.getBalanceByAccNum(accountNumber);
        Response<Double> response = new Response<>(true, balance);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getByAccNum/{accountNumber}")
    @ApiOperation(value = "Fetches the balance of the account using the Account Number.",
            notes = "Fetches the balance of the account corresponding to the given account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Account Type returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)
    })
    public ResponseEntity<Response<AccountDto>> getByAccNum(
            @ApiParam(value = "The accountNumber that identifies the Account.",
                    example = "1",
                    name = "accountNumber",
                    required = true)
            @PathVariable("accountNumber") Integer accountNumber) throws SQLException {
        AccountDto account = accountService.getByAccountNumber(accountNumber);
        Response<AccountDto> response = new Response<>(true, account);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
