package tech.byrsa.sindibad.rest.controller.userAccount.mapper;

import org.mapstruct.Mapper;

import tech.byrsa.sindibad.rest.controller.userAccount.dto.CreateUserAccountRequest;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

@Mapper
public interface UserAccountRestMapper {

	UserAccountCreate map(CreateUserAccountRequest createUserAccountRequest);

}
