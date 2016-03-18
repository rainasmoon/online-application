function setAging(age) {
	$('#aging').val(age);
}

function addNewTag() {

	if ($('#inputNewTag').val() == '') {
		return;
	}

	$('#tags_session').append(
			'<label><input type="checkbox" name="tags" value="'
					+ $('#inputNewTag').val()
					+ '" checked/><label class="label label-info"> '
					+ $('#inputNewTag').val() + '</label></label>');
	$('#inputNewTag').val('');
}