package tech.byrsa.sindibad.enterprise.port.out;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface GetOneEnterprise {

    Enterprise getOne(Long id);
}
