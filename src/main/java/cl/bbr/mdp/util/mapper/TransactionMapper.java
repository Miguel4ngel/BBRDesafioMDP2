package cl.bbr.mdp.util.mapper;

import cl.bbr.mdp.entity.Transaction;
import cl.bbr.mdp.service.dto.TransactionDto;
import cl.bbr.mdp.util.TransactionTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@Component
public class TransactionMapper {

    public static Transaction entityFromRequest (TransactionDto transactionDto) {
        return Transaction.builder()
                .type(TransactionTypeEnum.valueOf(transactionDto.getType()).getValue())
                .user(transactionDto.getUser())
                .amount(transactionDto.getAmount())
                .createdAt(Instant.now().toString())
                .commerce(transactionDto.getCommerce())
                .build();
    }

    public static TransactionDto transactionFromEntity(Transaction transaction) {
        return TransactionDto.builder()
                .type(TransactionTypeEnum.valueOf(transaction.getType()).getValue())
                .user(transaction.getUser())
                .commerce(transaction.getCommerce())
                .amount(transaction.getAmount())
                .createdAt(transaction.getCreatedAt())
                .build();
    }



}
