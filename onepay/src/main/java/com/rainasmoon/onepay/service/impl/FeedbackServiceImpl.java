package com.rainasmoon.onepay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainasmoon.onepay.model.Feedback;
import com.rainasmoon.onepay.repository.springdatajpa.FeedbackRepository;
import com.rainasmoon.onepay.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	@Transactional
	public String addFeedback(Feedback feedback) {

		feedbackRepository.save(feedback);

		return "谢谢反馈";
	}

	@Override
	@Transactional(readOnly = true)
	public List<Feedback> listAllFeedbacks() {
		Iterable<Feedback> feedbacks = feedbackRepository.findAll();
		List<Feedback> result = new ArrayList<>();
		for (Feedback f : feedbacks) {
			result.add(f);
		}
		return result;
	}

}
