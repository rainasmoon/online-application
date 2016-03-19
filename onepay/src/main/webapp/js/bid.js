function addMoney(productId, amount) {
	$.post("restful/bid", {
		productId : productId,
		money : amount
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}

function guessMoney(productId) {
	if ($("#guessPrice").val() == '') {
		alert("请输入数字");
		return;
	}
	var reg = new RegExp("^\\d+$"); 
	if (!reg.test($("#guessPrice").val())) {
		alert("请输入数字");
		return;
	}
	$.post("restful/guess", {
		productId : productId,
		money : $("#guessPrice").val()
	}, function(data, status) {
		$("#productPrice").text(data);
	});
}