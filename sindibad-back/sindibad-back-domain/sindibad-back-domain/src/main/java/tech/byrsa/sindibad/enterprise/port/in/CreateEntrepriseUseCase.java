package tech.byrsa.sindibad.enterprise.port.in;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface CreateEntrepriseUseCase {
    Enterprise add(Long responsable_id, Enterprise enterprise);
}
