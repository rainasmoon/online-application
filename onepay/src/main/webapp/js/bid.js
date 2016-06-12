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
	shakeThis("bid-price-button-" + amount);
	$.post("restful/bid", {
		productId : productId,
		money : amount
	}, function(data, status) {
		$("#productPrice").text(data);
		if (data == "未登录") {
			redirectToLoginPage();
		}
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
	shakeThis("guess-price-button");
	$.post("restful/guess", {
		productId : productId,
		money : $("#guessPrice").val()
	}, function(data, status) {
		$("#productPrice").text(data);
		if (data == "未登录") {
			redirectToLoginPage();
		}

	});

}

function redirectToLoginPage() {
	window.location.href = "login.html?toUrl=" + window.location.href;
}

function shakeThis(objId) {
	$("#" + objId).effect("shake", {
		distance : 1
	});
}