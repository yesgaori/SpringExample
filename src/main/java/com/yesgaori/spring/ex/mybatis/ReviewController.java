package com.yesgaori.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.ex.mybatis.domain.Review;
import com.yesgaori.spring.ex.mybatis.service.ReviewService;
@RequestMapping("/mybatis/review")
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 리퀘스트 파라미터와 전달된 id와 일치하는 리뷰 정보를 json으로 response에 담는다
	@RequestMapping("/id")
	@ResponseBody
	// request.getParameter("id");
	public Review review(@RequestParam("id") int id) {
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String createReview() {
		
		// 4, 치즈피자, 김인규, 4.5
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5);
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리 입니다.
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리 입니다.");
		
		int count = reviewService.addReviewByObject(review);
		
		return "수행결과" + count;
		
		
		
		
	}
	
}
