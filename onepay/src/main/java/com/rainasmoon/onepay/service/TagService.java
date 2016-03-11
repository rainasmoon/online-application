package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Tag;

public interface TagService {

	Tag addUserTag(Long userId, String tag);
	Tag addProductTag(Long productId, String tag);
	List<Tag> findUserTags(Long userId);
	List<Tag> findProductTags(Long productId);
}
