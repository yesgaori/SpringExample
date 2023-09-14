package com.yesgaori.spring.ex.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yesgaori.spring.ex.jpa.domain.Student;
import com.yesgaori.spring.ex.jpa.repository.StudentRepository;
import com.yesgaori.spring.ex.jpa.service.StudentService;


@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		
		String name= "김인규";
		String phoneNumber= "010-0000-1111";
		String email = "lecture@hagulu.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		
		return student;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 3인 학생정보의 장래희망을 강사로 수정
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
		
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		
		return "삭제 성공";
	}
	
	@GetMapping("/select")
	@ResponseBody
	public List<Student> getStudentList() {
		// 1) 전체 조회(기본으로 제공되는 메소드)
		//List<Student> studentList = studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
		//List<Student> studentList = studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
		//List<Student> studentList = studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 신보람인 데이터 조회
		//List<Student> studentList = studentRepository.findByName("김인규");

		// 5) in문으로 일치하는 값 모두 조회
		//List<Student> studentList = studentRepository.findByNameIn(Arrays.asList("김인규", "조세호", "신바다"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
		//List<Student> studentList = studentRepository.findByNameAndDreamJob("조세호", "변호사");
		
		// 7) email 컬럼에 naver 키워드가 포함된 데이터 조회(like문) - %naver%
		//List<Student> studentList = studentRepository.findByEmailContaining("naver");
		
		// 8) 이름이 김으로 시작하는 데이터 조회(like문) - 신%
		//List<Student> studentList = studentRepository.findByNameStartingWith("김");
		
		// 9) id가 1~5인 데이터 조회(between)
		List<Student> studentList = studentRepository.findByIdBetween(1, 5);
		return studentList;
	}
	
	// native query
	@GetMapping("/2")
	public List<Student> getStudent() {
		// 1) 장래희망이 대통령인 데이터 조회
		List<Student> list = studentRepository.findByDreamJob("대통령");
		
		return list;
	}
	
	
	@GetMapping("/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student();
//		student.setName("김인규");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5678");
		
		Student student = Student.builder()
							.name("김인규")
							.dreamJob("개발자")
							.phoneNumber("010-0000-1111")
							.build();
							
		return student;
	}
	
	
	
}
