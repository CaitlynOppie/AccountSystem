package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.TransactionDto;
import za.ac.nwu.as.logic.flow.CreateTransactionFlow;
import za.ac.nwu.as.translator.flow.TransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createATransactionFlowName")
public class CreateTransactionFlowImpl implements CreateTransactionFlow {

    private final TransactionTranslator transactionTranslator;

    public CreateTransactionFlowImpl(TransactionTranslator transactionTranslator) {
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
