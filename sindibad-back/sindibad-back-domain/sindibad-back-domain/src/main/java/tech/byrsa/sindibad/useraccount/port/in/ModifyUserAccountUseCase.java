package tech.byrsa.sindibad.useraccount.port.in;

import tech.byrsa.sindibad.useraccount.model.UserAccount;

public interface ModifyUserAccountUseCase {
    UserAccount modifyUserAccountUseCase(Long id, UserAccount userAccount);
}
