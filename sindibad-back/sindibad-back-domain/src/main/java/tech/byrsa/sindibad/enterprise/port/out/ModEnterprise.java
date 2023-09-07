package tech.byrsa.sindibad.enterprise.port.out;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface ModEnterprise {

    Enterprise mod(Long id, Enterprise ent);
}
