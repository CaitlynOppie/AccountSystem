package za.ac.nwu.as.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.CreateTransactionFlow;
import za.ac.nwu.as.logic.flow.FetchTransactionFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

//    private final FetchTransactionFlow fetchTransactionFlow;
//    private final CreateTransactionFlow createTransactionFlow;
//
//    @Autowired
//
//    public TransactionController(FetchTransactionFlow fetchTransactionFlow, CreateTransactionFlow createTransactionFlow) {
//        this.fetchTransactionFlow = fetchTransactionFlow;
//        this.createTransactionFlow = createTransactionFlow;
//    }
//
//    @GetMapping("/all")
//    @ApiOperation(value = "Gets all the Transactions.", notes = "Returns a list of transactions")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//
//    public ResponseEntity<GeneralResponse<String>> getAll() {
//        List<TransactionDto> transaction = fetchTransactionFlow.getAllTransactions();
//        GeneralResponse<String> response = new GeneralResponse<>(true,"No transactions found");
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PostMapping("")
//    @ApiOperation(value = "Creates new Transaction.", notes = "Creates a new transaction in the DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "The transaction was created successfully", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<TransactionDto>> create(
//            @ApiParam(value = "Request body to create a new Transaction.", required = true)
//            @RequestBody TransactionDto transaction) {
//        TransactionDto transactionResponse = createTransactionFlow.create(transaction);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transactionResponse);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
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
//        TransactionDto transaction = fetchTransactionFlow.getTransactionByAccountNumber(accountNumber);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/getTransactionByDate/{transactionDate}")
//    @ApiOperation(value = "Fetches the specified transactions using the transaction date.", notes = "Fetches the transactions corresponding to the given date")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<TransactionDto>> getTransactionByDate(
//            @ApiParam(value = "The date that identifies the Transactions.",
//                    example = "2021-08-31",
//                    name = "transactionDate",
//                    required = true)
//            @PathVariable("transactionDate")LocalDate transactionDate){
//        TransactionDto transaction = fetchTransactionFlow.getTransactionByDate(transactionDate);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/getTransactionByTransactionID/{transactionID}")
//    @ApiOperation(value = "Fetches the specified transactions using the transaction ID.", notes = "Fetches the transactions corresponding to the given transactionID")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<TransactionDto>> getTransactionByTransactionID(
//            @ApiParam(value = "The transactionID that identifies the Transactions.",
//                    example = "23",
//                    name = "transactionID",
//                    required = true)
//            @PathVariable("transactionID")Integer transactionID){
//        TransactionDto transaction = fetchTransactionFlow.getTransactionByTransactionID(transactionID);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/getTransactionByMemID/{memberID}")
//    @ApiOperation(value = "Fetches the specified transactions using the memberID.", notes = "Fetches the transactions corresponding to the given memberID")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Transactions returned", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 404, message = "Not Found", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
//    })
//    public ResponseEntity<GeneralResponse<TransactionDto>> getTransactionByMemID(
//            @ApiParam(value = "The memberID that identifies the Transactions.",
//                    example = "1",
//                    name = "memberID",
//                    required = true)
//            @PathVariable("memberID")Integer memberID){
//        TransactionDto transaction = fetchTransactionFlow.getTransactionByMemID(memberID);
//        GeneralResponse<TransactionDto> response = new GeneralResponse<>(true, transaction);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}