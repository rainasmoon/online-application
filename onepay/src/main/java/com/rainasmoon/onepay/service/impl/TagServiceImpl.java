package com.rainasmoon.onepay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainasmoon.onepay.enums.TagTypes;
import com.rainasmoon.onepay.model.Tag;
import com.rainasmoon.onepay.repository.springdatajpa.ProductRepository;
import com.rainasmoon.onepay.repository.springdatajpa.TagRepository;
import com.rainasmoon.onepay.service.TagService;
@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository repository;
	@Override
	public Tag addUserTag(Long userId, String tag) {
		Tag atag= new Tag();
		atag.setObjId(userId);
		atag.setName(tag);
		atag.setType(TagTypes.USER.getCode());
		atag = repository.save(atag);
		return atag;
	}

	@Override
	public Tag addProductTag(Long productId, String tag) {
		// TODO Auto-generated method stub
		return null;
	}

}
