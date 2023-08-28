package tech.byrsa.sindibad.rest.controller.userAccount;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.rest.controller.AbstractController;

import tech.byrsa.sindibad.rest.controller.userAccount.dto.CreateUserAccountRequest;
import tech.byrsa.sindibad.rest.controller.userAccount.mapper.UserAccountRestMapper;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.in.CreateUserAccountUseCase;

@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AbstractController.INDIVIDUAL + "users")
public class UserRestController {
	private final CreateUserAccountUseCase createUserAccountUseCase;
	private final UserAccountRestMapper userAccountRestMapper;
	
	@PostMapping
	public ResponseEntity<Long> createUserAccount(@RequestBody CreateUserAccountRequest createUserAccountRequest) {

		log.entry(createUserAccountRequest);
		UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
		Long id = createUserAccountUseCase.createUserAccount(userAccountCreate);

		log.exit(id);

		return ResponseEntity.ok(id);
	}

}
