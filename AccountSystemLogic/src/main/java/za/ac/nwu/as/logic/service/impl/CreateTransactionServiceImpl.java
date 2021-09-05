package za.ac.nwu.as.logic.service.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.service.CreateTransactionService;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createATransactionFlowName")
public class CreateTransactionServiceImpl implements CreateTransactionService {

    private final TransactionTranslator transactionTranslator;

    public CreateTransactionServiceImpl(TransactionTranslator transactionTranslator) {
        this.transactionTranslator = transactionTranslator;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        if(null == transactionDto.getTransactionDate()){
            transactionDto.setTransactionDate(LocalDate.now());
        }
        return transactionTranslator.create(transactionDto);
    }
}
