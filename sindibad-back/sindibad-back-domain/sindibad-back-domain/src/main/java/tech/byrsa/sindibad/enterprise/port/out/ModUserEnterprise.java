package tech.byrsa.sindibad.enterprise.port.out;

import tech.byrsa.sindibad.useraccount.model.UserAccount;

public interface ModUserEnterprise {
    UserAccount modify(Long resp, Long ent, Long usr, UserAccount userAccount);
}
