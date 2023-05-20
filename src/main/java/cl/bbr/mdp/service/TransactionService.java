package cl.bbr.mdp.service;

import cl.bbr.mdp.entity.Transaction;
import cl.bbr.mdp.repository.TransactionRepository;
import cl.bbr.mdp.service.dto.TransactionDto;
import cl.bbr.mdp.util.mapper.TransactionMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Value("${custom.global.commerce}")
	private String commerce;

	@Value("${custom.global.user}")
	private String user;

	public TransactionDto createTransaction (TransactionDto request) {
		log.info("[createTransaction] Transaction creation begins for request [{}]", request);
		request.setCommerce(commerce);
		request.setUser(user);
		Transaction createdTransaction = transactionRepository.save(TransactionMapper.entityFromRequest(request));
		log.info("[createTransaction] Transaction created with Id [{}]", createdTransaction.getId());
		request.setCreatedAt(createdTransaction.getCreatedAt());
		return request;
	}

	public List<TransactionDto> findTransactions (Optional<String> transactionType) {
		log.info("[findTransactions] Search Transaction Begins.");
		List<TransactionDto> transactionList = new ArrayList<>();
		transactionType.ifPresentOrElse(value -> {
			log.info("[findTransactions] TransactionType [{}]", transactionType.get());
			buildTransactionList(transactionRepository.findByType(value), transactionList);
		}, () -> {
			log.info("[findTransactions] Searching all Transactions.");
			buildTransactionList(transactionRepository.findAll(), transactionList);
		});
		log.info("[findTransactions] Search transactions End.");
		return transactionList;
	}

	public void buildTransactionList(List<Transaction> foundTransactions, List<TransactionDto> transactionList) {
		log.info("[buildTransactionList] Building response list with [{}] founded transactions.", foundTransactions.size());
		foundTransactions.forEach(transaction -> {
			transactionList.add(TransactionMapper.transactionFromEntity(transaction));
		});
	}
	
}
