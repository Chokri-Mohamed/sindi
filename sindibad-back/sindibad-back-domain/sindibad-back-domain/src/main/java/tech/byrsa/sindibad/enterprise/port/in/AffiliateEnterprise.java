package tech.byrsa.sindibad.enterprise.port.in;

import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

public interface AffiliateEnterprise {
    String affiliate(Long resp_id, Long ent_id, UserAccountCreate userAccountCreate);
}
