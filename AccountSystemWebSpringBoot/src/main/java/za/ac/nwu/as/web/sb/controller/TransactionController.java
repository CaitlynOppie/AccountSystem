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
import za.ac.nwu.as.logic.service.CreateTransactionService;
import za.ac.nwu.as.logic.service.GetTransactionService;
import za.ac.nwu.as.logic.service.UpdateAccountService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final GetTransactionService getTransactionService;
    private final CreateTransactionService createTransactionService;
    private final UpdateAccountService updateAccountService;

    @Autowired

    public TransactionController(GetTransactionService getTransactionService, CreateTransactionService createTransactionService, UpdateAccountService updateAccountService) {
        this.getTransactionService = getTransactionService;
        this.createTransactionService = createTransactionService;
        this.updateAccountService = updateAccountService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the Transactions.", notes = "Returns a list of transactions")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Transactions returned", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Response.class)})

    public ResponseEntity<Response<List<TransactionDto>>> getAll() {
        List<TransactionDto> transaction = getTransactionService.getAllTransactions();
        Response<List<TransactionDto>> response = new Response<>(true,transaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("add-to-balance/{accountNumber}/{amount}")
    @ApiOperation(value = "Creates new Transaction.", notes = "Creates a new transaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The transaction was created successfully", response = Response.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Response.class),
            @ApiResponse(code = 404, message = "Not Found", response = Response.class)
    })
    public ResponseEntity<Response<TransactionDto>> create(
            @ApiParam(value = "Request body to create a new Transaction.", required = true)
            @RequestBody TransactionDto transaction) {
        TransactionDto transactionResponse = createTransactionService.create(transaction);
        Response<TransactionDto> response = new Response<>(true, transactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }








//    @GetMapping("/getTransactionByAccountNumber/{accountNumber}")
//    @ApiOperation(value = "Fetches the specified transactions using the account number.", notes = "Fetches the transactions corresponding to the given account number")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<TransactionDto>> getTransactionByAccountNumber(
//            @ApiParam(value = "The account number that identifies the Transactions.",
//                    example = "123456789",
//                    name = "accountNumber",
//                    required = true)
//            @PathVariable("accountNumber") Integer accountNumber){
//        TransactionDto transaction = getTransactionService.getTransactionByAccountNumber(accountNumber);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}
