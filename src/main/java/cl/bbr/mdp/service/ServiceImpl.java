package cl.bbr.mdp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bbr.mdp.entity.EntityTransaction;
import cl.bbr.mdp.repository.TrxRepository;


@Service
public class ServiceImpl implements Service {
	
	enum Type
	{
	    DEBITO, CREDITO, CHEQUE, EFECTIVO;
	}
	
	@Autowired
	private TrxRepository trxRepository;
	
	@Override
	public EntityTransaction createRamdonTrx () {
		
		EntityTransaction entTrx = new EntityTransaction ();
		Random ran = new Random();
		int amount = ran.nextInt(6000) + 5000;
		entTrx.setType( Type.values()[new Random().nextInt(Type.values().length)].toString());
		entTrx.setAmount(amount);
		trxRepository.save( entTrx );
		
		return entTrx;
		
	}
	
}
