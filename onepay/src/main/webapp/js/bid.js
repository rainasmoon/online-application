if ($('#saleModel').val() != 'guess_price') {
	setInterval(function() {
		$.post("restful/bid/refresh", {
			productId : $('#productId').val(),
		}, function(data, status) {
			$("#currentOwner").text(data.currentOwnerName);
			$("#productPrice").text(data.price);
		}, 'json');
	}, 5000);
}

function addMoney(productId, amount) {
	$("#bid-price-button-" + amount).effect( "shake",{ distance: 3 } );
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
	$("#guess-price-button").effect( "shake",{ distance: 3 } );
	$.post("restful/guess", {
		productId : productId,
		money : $("#guessPrice").val()
	}, function(data, status) {
		$("#productPrice").text(data);
		
	});
	
	
}