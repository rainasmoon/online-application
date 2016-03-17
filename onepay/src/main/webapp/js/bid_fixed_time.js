function addMoney(amount) {
	$.post("restful/bid", {
		productId : '${productVo.productId}',
		money : amount
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}