package tech.byrsa.sindibad.enterprise.port.in;

import tech.byrsa.sindibad.useraccount.model.UserAccount;

public interface ModUserEnterpriseUseCase {
    UserAccount modify(Long resp, Long ent, Long usr, UserAccount userAccount);
}
