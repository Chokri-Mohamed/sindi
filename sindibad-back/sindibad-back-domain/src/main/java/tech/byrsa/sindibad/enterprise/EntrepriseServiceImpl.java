package tech.byrsa.sindibad.enterprise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.in.AffiliateEnterprise;
import tech.byrsa.sindibad.enterprise.port.in.CreateEntrepriseUseCase;
import tech.byrsa.sindibad.enterprise.port.in.GetOneEnterpriseUseCase;
import tech.byrsa.sindibad.enterprise.port.in.ModifyEnterpriseUseCase;
import tech.byrsa.sindibad.enterprise.port.out.AffiliateEnterpriseDb;
import tech.byrsa.sindibad.enterprise.port.out.GetOneEnterprise;
import tech.byrsa.sindibad.enterprise.port.out.ModEnterprise;
import tech.byrsa.sindibad.enterprise.port.out.SaveEntreprise;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements AffiliateEnterprise, CreateEntrepriseUseCase, ModifyEnterpriseUseCase, GetOneEnterpriseUseCase {

    private final SaveEntreprise saveEntreprise;
    private final GetUserAccount getUserAccount;
    private final GetOneEnterprise getOneEnterprise;
    private final ModEnterprise modEnterprise;
    private final AffiliateEnterpriseDb affiliateEnterpriseDb;

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
}
