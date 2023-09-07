package tech.byrsa.sindibad.adapter.enterprise;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Component;
import tech.byrsa.sindibad.adapter.useraccount.UserAccountJpaAdapter;
import tech.byrsa.sindibad.adapter.useraccount.UserAccountJpaAdapterMapper;
import tech.byrsa.sindibad.database.entity.EnterpriseDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.database.repository.EnterpriseRepository;
import tech.byrsa.sindibad.database.repository.UserAccountRepository;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.out.AffiliateEnterpriseDb;
import tech.byrsa.sindibad.enterprise.port.out.GetOneEnterprise;
import tech.byrsa.sindibad.enterprise.port.out.ModEnterprise;
import tech.byrsa.sindibad.enterprise.port.out.SaveEntreprise;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;
import tech.byrsa.sindibad.useraccount.port.out.GetUserAccount;
import tech.byrsa.sindibad.useraccount.port.out.SaveUserAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XSlf4j
@Component
@RequiredArgsConstructor
public class EnterpriseJpaAdapter implements SaveEntreprise, GetOneEnterprise, ModEnterprise, AffiliateEnterpriseDb {

    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseJpaAdapterMapper enterpriseJpaAdapterMapper;
    private final UserAccountJpaAdapterMapper userAccountJpaAdapterMapper;
    private final UserAccountRepository userAccountRepository;
    private final UserAccountJpaAdapter userAccountJpaAdapter;

    @Override
    public Enterprise handle(Enterprise enterprise) {
        UserAccountDb uad = userAccountRepository.findById(enterprise.getResponsableUser().getId()).orElse(null);
        System.err.println(uad);
        EnterpriseDb ed = enterpriseJpaAdapterMapper.map(enterprise, uad);
        ed.setResponsableUser(uad);
        System.err.println(ed);
        ed = enterpriseRepository.save(ed);
        Enterprise ee = enterpriseJpaAdapterMapper.map(ed);
        return ee;
    }

    @Override
    public Enterprise getOne(Long id) {
        EnterpriseDb ed = enterpriseRepository.findById(id).orElse(null);
        if(ed == null) return null;
        Enterprise ee = enterpriseJpaAdapterMapper.map(ed);
        return ee;
    }

    @Override
    public Enterprise mod(Long id, Enterprise enterprise) {
        UserAccountDb uad = userAccountRepository.findById(enterprise.getResponsableUser().getId()).orElse(null);
        System.err.println(uad);
        EnterpriseDb entdb = enterpriseRepository.findById(enterprise.getId()).orElse(null);
        //EnterpriseDb ed = enterpriseJpaAdapterMapper.map(enterprise, uad);
        entdb.setResponsableUser(uad);
        entdb.setFiscalNum(enterprise.getFiscalNum());
        entdb.setName(enterprise.getName());
        //System.err.println(entdb);
        entdb = enterpriseRepository.save(entdb);
        Enterprise ee = enterpriseJpaAdapterMapper.map(entdb);
        return ee;
    }

    @Override
    public String affiliate(Long resp_id, Long ent_id, UserAccountCreate userAccountCreate) {
        EnterpriseDb entdb = enterpriseRepository.findById(ent_id).orElse(null);
        if(entdb == null) return null;
        if(!Objects.equals(entdb.getResponsableUser().getId(), resp_id)) return null;
        UserAccount ua = userAccountJpaAdapter.createUserAccount(userAccountCreate);
        UserAccountDb uad = userAccountRepository.findById(ua.getId()).orElse(null);
        List<UserAccountDb> list = entdb.getMembers();
        if(list == null) list = new ArrayList<>();
        list.add(uad);
        entdb.setMembers(list);
        enterpriseRepository.save(entdb);
        return "done";
    }
}
