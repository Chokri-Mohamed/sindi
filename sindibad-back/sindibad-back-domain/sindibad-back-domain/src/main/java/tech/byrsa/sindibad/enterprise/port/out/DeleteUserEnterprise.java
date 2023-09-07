package tech.byrsa.sindibad.enterprise.port.out;

public interface DeleteUserEnterprise {
    boolean delete(Long resp, Long ent, Long usr);
}
