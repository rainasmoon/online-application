package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Bonus;
import com.rainasmoon.onepay.model.Check;

public interface FinanceService {

	void saveCheck(String email, Check check);

	List<Check> findAllChecks(String email);

	List<Bonus> findAllBonus(String email);

}
