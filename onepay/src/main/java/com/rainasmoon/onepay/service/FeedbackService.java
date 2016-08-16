package com.rainasmoon.onepay.service;

import java.util.List;

import com.rainasmoon.onepay.model.Feedback;

public interface FeedbackService {

	String addFeedback(Feedback feedback);

	List<Feedback> listAllFeedbacks();
}
