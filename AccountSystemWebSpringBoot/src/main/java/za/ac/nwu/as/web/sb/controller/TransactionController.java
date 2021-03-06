package za.ac.nwu.as.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.service.Response;
import za.ac.nwu.as.logic.service.AccountService;
import za.ac.nwu.as.logic.service.TransactionService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    @Autowired

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Transactions.", notes = "Returns a list of transactions")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Transactions returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)})

    public ResponseEntity<Response<List<TransactionDto>>> getAll() throws SQLException {
        List<TransactionDto> transaction = transactionService.getAllTransactions();
        Response<List<TransactionDto>> response = new Response<>(true,transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates new Transaction.", notes = "Creates a new Transaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Transaction was created successfully", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class)
    })
    public ResponseEntity<Response<TransactionDto>> create(
            @ApiParam(value = "Request body to create a new Transaction.", required = true)
            @RequestBody TransactionDto transaction) throws SQLException {
        TransactionDto transactionResponse = transactionService.create(transaction);
        Response<TransactionDto> response = new Response<>(true, transactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getTransactionByAccountNum/{accNum}")
    @ApiOperation(value = "Fetches the specified transactions using the account number.", notes = "Fetches the transactions using the account number")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Member returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)
    })
    public ResponseEntity<Response< List<TransactionDto>>> getTransactionByAccNum(
            @ApiParam(value = "The account number that identifies the transactions.",
                    example = "1",
                    name = "accNum",
                    required = true)
            @PathVariable("accNum") Integer accNum) throws SQLException {
        List<TransactionDto> transaction = transactionService.getTransactionByAccountNumber(accNum);
        Response< List<TransactionDto>> response = new Response<>(true, transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
