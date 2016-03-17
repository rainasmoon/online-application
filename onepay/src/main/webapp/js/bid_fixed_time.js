function addMoney(productId, amount) {
	$.post("restful/bid", {
		productId : productId,
		money : amount
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}