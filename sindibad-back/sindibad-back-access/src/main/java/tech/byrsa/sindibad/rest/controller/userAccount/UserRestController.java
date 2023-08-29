package tech.byrsa.sindibad.rest.controller.userAccount;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.rest.controller.AbstractController;

import tech.byrsa.sindibad.rest.controller.userAccount.dto.CreateUserAccountRequest;
import tech.byrsa.sindibad.rest.controller.userAccount.mapper.UserAccountRestMapper;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.in.CreateUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.in.GetUserAccountUseCase;
import tech.byrsa.sindibad.useraccount.port.in.ModifyUserAccountUseCase;

@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AbstractController.INDIVIDUAL + "users")
public class UserRestController {
	private final CreateUserAccountUseCase createUserAccountUseCase;
	private final UserAccountRestMapper userAccountRestMapper;

	private final GetUserAccountUseCase getUserAccountUseCase;

	private final ModifyUserAccountUseCase modifyUserAccountUseCase;

	@PostMapping
	public ResponseEntity<Long> createUserAccount(@RequestBody CreateUserAccountRequest createUserAccountRequest) {

		log.entry(createUserAccountRequest);
		UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
		Long id = createUserAccountUseCase.createUserAccount(userAccountCreate);

		log.exit(id);

		return ResponseEntity.ok(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UserAccount> getUserAccount(@PathVariable("id") Long id) {

		log.entry(id);
		//UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
		UserAccount user = getUserAccountUseCase.getUserById(id);
		if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);

		log.exit(id);

		return ResponseEntity.ok(user);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserAccount> modifyUser(@PathVariable("id") Long id, @RequestBody UserAccount userAccount) {

		log.entry(id);
		//UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
		UserAccount user = modifyUserAccountUseCase.modifyUserAccountUseCase(id, userAccount);
		if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);

		log.exit(id);

		return ResponseEntity.ok(user);
	}
}
