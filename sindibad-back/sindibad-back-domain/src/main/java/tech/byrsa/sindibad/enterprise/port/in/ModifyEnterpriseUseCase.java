package tech.byrsa.sindibad.enterprise.port.in;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface ModifyEnterpriseUseCase {

    Enterprise mod(Long responsable_id, Long ent_id, Enterprise enterprise);
}
