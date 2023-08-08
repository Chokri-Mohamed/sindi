package tech.byrsa.sindibad.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserAccountController {
	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public String hello() {
		return "hello";
	}

}
