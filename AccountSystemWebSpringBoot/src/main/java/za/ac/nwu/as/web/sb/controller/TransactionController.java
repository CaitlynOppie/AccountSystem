package za.ac.nwu.as.web.sb.controller;


import org.springframework.web.bind.annotation.*;

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
//    public ResponseEntity<GeneralResponse<List<TransactionDto>>> getAll() {
//        List<TransactionDto> transaction = fetchTransactionFlow.getAllTransactions();
//        GeneralResponse<List<TransactionDto>> response = new GeneralResponse<>(true,transaction);
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
