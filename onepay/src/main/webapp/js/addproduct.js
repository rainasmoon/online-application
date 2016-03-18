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

$(document).ready(function() {

	showPriceSession();
});