function addMoney(productId, amount) {
	$.post("restful/bid", {
		productId : productId,
		money : amount
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}

function guessMoney(productId) {
	$.post("restful/guess", {
		productId : productId,
		money : $("#guessPrice").val()
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}