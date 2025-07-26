package com.progresssoft.dealcluster;

import com.progresssoft.dealcluster.dto.DealRequestDto;
import com.progresssoft.dealcluster.entity.DealEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
		classes = TestDealclusterApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class DealclusterApplicationTests {

	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper mapper;

	@Test
	void contextLoads() {
		// sanity check: app and Testcontainers started
	}

	@Test
	void importAndFetchDeal() throws Exception {
		DealRequestDto dto = DealRequestDto.builder()
				.dealUniqueId("test-123")
				.orderingCurrency("USD")
				.targetCurrency("EUR")
				.dealTimestamp(Instant.now())
				.dealAmount(new BigDecimal("100.00"))
				.build();

		// 1) import the deal
		mockMvc.perform(post("/api/deals")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(dto)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.dealUniqueId").value("test-123"));

		// 2) duplicate import should 409
		mockMvc.perform(post("/api/deals")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(dto)))
				.andExpect(status().isConflict());
	}
}
