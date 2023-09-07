package tech.byrsa.sindibad.enterprise.port.in;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface GetOneEnterpriseUseCase {
    Enterprise one(Long id);
}
