package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.ResetPasswordApplication;

public interface ResetPasswordService {
	String addApplication(ResetPasswordApplication application);

	List<ResetPasswordApplication> listAllApplications();

}
