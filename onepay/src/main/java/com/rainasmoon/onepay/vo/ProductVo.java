package com.rainasmoon.onepay.vo;

import com.rainasmoon.onepay.enums.OperationEnum;
import com.rainasmoon.onepay.enums.ProductStatus;
import com.rainasmoon.onepay.enums.SaleModels;
import com.rainasmoon.onepay.model.Product;

public class ProductVo extends Product {

	private String currentBiderName;
	private OperationEnum operation;

	public String getCurrentBiderName() {
		return currentBiderName;
	}

	public void setCurrentBiderName(String currentBiderName) {
		this.currentBiderName = currentBiderName;
	}

	public SaleModels getEnumSaleModel() {
		return SaleModels.valueOf(getSaleModel());
	}

	public ProductStatus getEnumStatus() {
		return ProductStatus.valueOf(getStatus());
	}

	public OperationEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}

}
