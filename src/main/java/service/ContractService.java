package service;

import java.util.List;

import po.Contract;
import po.User;

public interface ContractService {
	List<Contract> getContractlist();

	void add(User user);
}
