package tech.byrsa.sindibad.useraccount.port.in;

import tech.byrsa.sindibad.useraccount.model.UserAccount;

public interface GetUserAccountUseCase {

    UserAccount getUserById(Long id);
}
