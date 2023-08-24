package com.yesgaori.spring.ex.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.ex.mybatis.domain.Review;
import com.yesgaori.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 파라미터로 전달 받은 id와 일치하는 리뷰 정보 조회
	public Review getReview(int id) {
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
}
