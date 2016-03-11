package com.rainasmoon.onepay.service;

import com.rainasmoon.onepay.model.Tag;

public interface TagService {

	Tag addUserTag(Long userId, String tag);
	Tag addProductTag(Long productId, String tag);
}
