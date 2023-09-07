package tech.byrsa.sindibad.enterprise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.in.*;
import tech.byrsa.sindibad.enterprise.port.out.*;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements AffiliateEnterprise, CreateEntrepriseUseCase, ModifyEnterpriseUseCase, GetOneEnterpriseUseCase, DeleteUserEnterpriseUseCase, DeleteEnterpriseUseCase, ModUserEnterpriseUseCase {

    private final SaveEntreprise saveEntreprise;
    private final GetUserAccount getUserAccount;
    private final GetOneEnterprise getOneEnterprise;
    private final ModEnterprise modEnterprise;
    private final AffiliateEnterpriseDb affiliateEnterpriseDb;
    private final DeleteEnterprise deleteEnterprise;
    private final DeleteUserEnterprise deleteUserEnterprise;
    private final ModUserEnterprise modUserEnterprise;

    @Override
    public Enterprise add(Long responsable_id, Enterprise enterprise) {
        UserAccount us = getUserAccount.getUserAccountById(responsable_id);
        if(us==null) return null;
        UserAccount ua = new UserAccount();
        ua.setId(responsable_id);
        enterprise.setResponsableUser(ua);
        Enterprise e = saveEntreprise.handle(enterprise);
        return e;
    }

    @Override
    public Enterprise mod(Long responsable_id, Long ent_id, Enterprise enterprise) {
        UserAccount us = getUserAccount.getUserAccountById(responsable_id);
        if(us==null) return null;
        Enterprise e = getOneEnterprise.getOne(ent_id);
        if(e == null) return null;
        //check if user is responsible for this enterprise
        System.err.println(e);
        if(!Objects.equals(e.getResponsableUser().getId(), responsable_id)) return null;
        e.setName(enterprise.getName());
        e.setFiscalNum(enterprise.getFiscalNum());
        e = modEnterprise.mod(responsable_id, e);
        return e;
    }

    @Override
    public Enterprise one(Long id) {
        Enterprise e = getOneEnterprise.getOne(id);
        return e;
    }

    @Override
    public String affiliate(Long resp_id, Long ent_id, UserAccountCreate userAccountCreate) {
        return affiliateEnterpriseDb.affiliate(resp_id, ent_id, userAccountCreate);
    }

    @Override
    public boolean delete(Long resp, Long ent) {
        UserAccount us = getUserAccount.getUserAccountById(resp);
        if(us==null) return false;
        Enterprise e = getOneEnterprise.getOne(ent);
        if(e == null) return false;
        //check if user is responsible for this enterprise
        if(!Objects.equals(e.getResponsableUser().getId(), resp)) return false;
        deleteEnterprise.delete(resp, ent);
        return true;
    }


    @Override
    public UserAccount modify(Long resp, Long ent, Long usr, UserAccount userAccount) {
        return modUserEnterprise.modify(resp,ent,usr,userAccount);
    }

    @Override
    public boolean delete(Long resp, Long ent, Long usr) {
        return deleteUserEnterprise.delete(resp, ent, usr);
    }
}
