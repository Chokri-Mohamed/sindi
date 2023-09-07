package tech.byrsa.sindibad.enterprise.port.out;

import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

public interface AffiliateEnterpriseDb {
    String affiliate(Long resp_id, Long ent_id, UserAccountCreate userAccountCreate);
}
