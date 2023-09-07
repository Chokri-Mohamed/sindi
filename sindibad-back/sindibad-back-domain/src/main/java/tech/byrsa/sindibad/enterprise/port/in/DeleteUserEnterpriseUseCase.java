package tech.byrsa.sindibad.enterprise.port.in;

public interface DeleteUserEnterpriseUseCase {
    boolean delete(Long resp, Long ent, Long usr);
}
