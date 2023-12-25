package com.s2u.admissionregistryservice.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2u.admissionregistryservice.domain.ReceptionAggregateBO;
import com.s2u.admissionregistryservice.service.ReceptionService;
import com.s2u.commonlib.util.MapSerializer;

@RestController
@RequestMapping("/api/v1/inquiryStudent")
public class ReceptionController {

	private static final Logger LOG = LoggerFactory.getLogger(ReceptionController.class);

	@Autowired(required = true)
	ReceptionService receptionService;

	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "Admission Registry Service is Up";

	}

	@PostMapping
	private Map<String, Object> addInquiryStudent(@RequestBody Map<String, Object> inquiryStudentMap) {
		LOG.info("POST Request {} ", inquiryStudentMap);
		ReceptionAggregateBO receptionAggregateBO = MapSerializer.fromMap(inquiryStudentMap,
				ReceptionAggregateBO.class);
		return MapSerializer.toMap(receptionService.addInquiryStudent(receptionAggregateBO));

	}
}
