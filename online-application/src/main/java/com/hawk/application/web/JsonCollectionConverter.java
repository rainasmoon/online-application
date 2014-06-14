package com.hawk.application.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonCollectionConverter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JsonCollectionConverter.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ObjectMapper mapper;

	public <T> String collectionToJSONString(final Collection<T> collection)
			throws JsonConversionException {
		final OutputStream out = new ByteArrayOutputStream();

		try {
			mapper.writeValue(out, collection);
		} catch (JsonGenerationException e) {
			LOGGER.warn("json conver error...");
			throw new JsonConversionException("json conver error...", e);
		} catch (JsonMappingException e) {
			LOGGER.warn("json conver error...");
			throw new JsonConversionException("json conver error...", e);
		} catch (IOException e) {
			LOGGER.warn("json conver error...");
			throw new JsonConversionException("json conver error...", e);
		}

		final byte[] data = ((ByteArrayOutputStream) out).toByteArray();
		return new String(data);
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

}
