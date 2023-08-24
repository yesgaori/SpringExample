package com.yesgaori.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.ex.mybatis.domain.Review;
import com.yesgaori.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 리퀘스트 파라미터와 전달된 id와 일치하는 리뷰 정보를 json으로 response에 담는다
	@RequestMapping("/mybatis/review")
	@ResponseBody
	// request.getParameter("id");
	public Review review(@RequestParam("id") int id) {
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
}
