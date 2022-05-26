package com.nguyenphitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenphitan.service.KafkaSender;

@RestController
@RequestMapping("/javainuse-kafka")
public class KafkaWebController {

	@Autowired
	private KafkaSender kafkaSender;

	@GetMapping("/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}