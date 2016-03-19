package com.rainasmoon.onepay.vo;

import com.rainasmoon.onepay.enums.YunModels;
import com.rainasmoon.onepay.enums.YunOperationEnum;
import com.rainasmoon.onepay.enums.YunStatus;
import com.rainasmoon.onepay.model.YunOrder;

public class YunOrderVo extends YunOrder {

	private String userName;
	private String userLevelName;
	private Integer userCredit;
	private YunOperationEnum operation;

	public YunModels getEnumModel() {
		return YunModels.valueOf(getModel());
	}

	public YunStatus getEnumStatus() {
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public Integer getUserCredit() {
		return userCredit;
	}

	public void setUserCredit(Integer userCredit) {
		this.userCredit = userCredit;
	}
}
