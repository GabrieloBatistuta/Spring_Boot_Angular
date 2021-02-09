package com.enjoycoding.restservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.enjoycoding.restservices.entity.Course;

@SpringBootTest
public class CourseTest {
	
	@Test
	public void objectTest() {
		
		Course c1 = new Course();
		assertEquals(c1.getTitle(), null);
	}

}
