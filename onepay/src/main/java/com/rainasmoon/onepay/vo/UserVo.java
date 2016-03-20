package com.rainasmoon.onepay.vo;

import com.rainasmoon.onepay.model.User;
import com.rainasmoon.onepay.util.CommonUtils;

public class UserVo extends User {

	public String getLevelName() {
		return CommonUtils.getUserLevel(getLevel());
	}

}
