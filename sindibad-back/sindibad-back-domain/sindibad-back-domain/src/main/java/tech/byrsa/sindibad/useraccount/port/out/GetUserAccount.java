package tech.byrsa.sindibad.useraccount.port.out;

import tech.byrsa.sindibad.useraccount.model.UserAccount;

public interface GetUserAccount {
    UserAccount getUserAccountById(Long id);
}
