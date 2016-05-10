function setAging(age) {
	$('#aging').val(age);
}

function addNewTag() {

	if ($('#inputNewTag').val() == '') {
		alert("tag 不能为空");
		return;
	}

	$('#tags_session').append(
			'<label><input type="checkbox" name="tags" value="'
					+ $('#inputNewTag').val()
					+ '" checked/><label class="label label-info"> '
					+ $('#inputNewTag').val() + '</label></label>');
	$('#inputNewTag').val('');
}

function showPriceSession() {

	if ($('[name="saleModel"]:checked').val() == 'guess_price') {
		$('#showBasePrice').slideDown();
	} else {
		$('#showBasePrice').slideUp();
	}
}

function checkboxChanged() {
	console.log($("#checkbox_agreement:checked").val() == "on");
	if (!($("#checkbox_agreement:checked").val() == "on")) {
		$("#submit").attr("disabled", "disabled");
	} else {
		$("#submit").removeAttr("disabled");
	}

}

function fileChange(e) {

	var f = e.files[0];// 一次只上传1个文件，其实可以上传多个的
	var FR = new FileReader();

	FR.onload = function(f) {
		compressImg(this.result, 600, function(data) {// 压缩完成后执行的callback
			console.log("compress finished.");
			console.log(data);

			var c = document.getElementById("myCanvas");
			var cxt = c.getContext("2d");
			var img = new Image();
			img.src = data;
			cxt.drawImage(img, 0, 0);
		});
	};

	FR.readAsDataURL(f);// 先注册onload，再读取文件内容，否则读取内容是空的

}

function compressImg(imgData, maxHeight, onCompress) {
	if (!imgData) {
		return;
	}

	onCompress = onCompress || function() {
	};

	maxHeight = maxHeight || 200;// 默认最大高度200px
	var canvas = document.createElement('canvas');
	var img = new Image();

	img.onload = function() {

		if (img.height > maxHeight) {// 按最大高度等比缩放
			img.width *= maxHeight / img.height;
			img.height = maxHeight;
		}

		var ctx = canvas.getContext("2d");
		ctx.clearRect(0, 0, canvas.width, canvas.height); // canvas清屏

		// 重置canvans宽高 canvas.width = img.width; canvas.height = img.height;
		ctx.drawImage(img, 0, 0, img.width, img.height); // 将图像绘制到canvas上

		onCompress(canvas.toDataURL("image/jpeg"));// 必须等压缩完才读取canvas值，否则canvas内容是黑帆布

	};

	// 记住必须先绑定事件，才能设置src属性，否则img没内容可以画到canvas
	img.src = imgData;
}

$(document).ready(function() {

	showPriceSession();
});