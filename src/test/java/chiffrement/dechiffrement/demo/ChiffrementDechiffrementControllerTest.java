package chiffrement.dechiffrement.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import chiffrement.dechiffrement.demo.common.ChiffrementRequest;
import chiffrement.dechiffrement.demo.common.DechiffrementRequest;
import chiffrement.dechiffrement.demo.service.ChiffrementDechiffrementServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ChiffrementDechiffrementControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChiffrementDechiffrementServiceImpl  chiffrementDechiffrementServiceImpl;


	@Test
	public void chiffrementTest() throws Exception {

		ChiffrementRequest chiffrementRequest = new ChiffrementRequest();
		chiffrementRequest.setChaine("Paris@France");
		chiffrementRequest.setCle("webnet");

		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/eni/chiff")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(chiffrementRequest))
				.characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andReturn();
	}
	
	@Test
	public void dechiffrementTest() throws Exception {
		
		DechiffrementRequest dechiffrementRequest = new DechiffrementRequest();
		dechiffrementRequest.setChaineCryptee("P1MMENep72wAlU3dspjurYCDSmkUoA8QwLWINvcwMOs%3D");
		dechiffrementRequest.setCle("webnet");
		
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/eni/dechi")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(dechiffrementRequest))
				.characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andReturn();
	}



}
