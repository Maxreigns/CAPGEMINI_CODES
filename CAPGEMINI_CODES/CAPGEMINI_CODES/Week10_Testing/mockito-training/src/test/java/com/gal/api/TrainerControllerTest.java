package com.gal.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gal.model.Training;
import com.gal.service.TrainingService;
//@SpringBootTest //this will run the project and then you can use hhtpClient
@WebMvcTest(TrainingController.class)
class TrainerControllerTest {

	@MockitoBean
	TrainingService trainingService;
	@Autowired
	MockMvc mockMvc;

	@Test
	void testById() throws Exception {
		Training t=new Training(101,Date.valueOf("2026-03-07"),Date.valueOf("2026-04-06"),"Sprint","Dinesh Kumar");
		when(trainingService.findById(101)).thenReturn(t);
		mockMvc.perform(get("/training/101").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.trainingid").value("101"));
	}

}
