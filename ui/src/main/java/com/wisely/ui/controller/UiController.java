package com.wisely.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.ui.domain.Person;
import com.wisely.ui.service.PersonHystrixService;
import com.wisely.ui.service.SomeHystrixService;

/**
 * 前端界面统一入口
 */
@RestController
public class UiController {

	@Autowired
	private SomeHystrixService someHystrixService;

	@Autowired
	private PersonHystrixService personHystrixService;

	@RequestMapping("/dispatch") // 调用person服务
	public List<Person> sendMessage(@RequestBody String personName) {
		return personHystrixService.save(personName);
	}

	// 调用some服务
	@RequestMapping(value = "/getsome", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String getSome() {
		return someHystrixService.getSome();
	}
}