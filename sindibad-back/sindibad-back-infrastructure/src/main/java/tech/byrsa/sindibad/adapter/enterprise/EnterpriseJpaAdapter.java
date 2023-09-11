package tech.byrsa.sindibad.adapter.enterprise;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tech.byrsa.sindibad.adapter.useraccount.UserAccountJpaAdapter;
import tech.byrsa.sindibad.adapter.useraccount.UserAccountJpaAdapterMapper;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.EnterpriseDb;
import tech.byrsa.sindibad.database.entity.UserAccountDb;
import tech.byrsa.sindibad.database.repository.EnterpriseRepository;
import tech.byrsa.sindibad.database.repository.UserAccountRepository;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.out.*;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.port.out.SearchAdvert;
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
public class EnterpriseJpaAdapter implements SaveEntreprise, GetOneEnterprise, ModEnterprise, AffiliateEnterpriseDb, DeleteEnterprise, ModUserEnterprise, DeleteUserEnterprise {

    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseJpaAdapterMapper enterpriseJpaAdapterMapper;
    private final UserAccountJpaAdapterMapper userAccountJpaAdapterMapper;
    private final UserAccountRepository userAccountRepository;
    private final UserAccountJpaAdapter userAccountJpaAdapter;
    private final PasswordEncoder passwordEncoder ;

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
    	final String encodedPassword = passwordEncoder.encode(userAccountCreate.getPassword());
        userAccountCreate.setPassword(encodedPassword);
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

    @Override
    public boolean delete(Long resp, Long ent) {
        EnterpriseDb entdb = enterpriseRepository.findById(ent).orElse(null);
        if(entdb == null) return false;
        if(!Objects.equals(entdb.getResponsableUser().getId(), resp)) return false;
        enterpriseRepository.deleteById(ent);
        return true;
    }

    @Override
    public UserAccount modify(Long resp, Long ent, Long usr, UserAccount userAccount) {
        UserAccountDb uad = userAccountRepository.findById(resp).orElse(null);
        if(uad == null) return null;
        EnterpriseDb entdb = enterpriseRepository.findById(ent).orElse(null);
        if(entdb == null) return null;
        if(!Objects.equals(entdb.getResponsableUser().getId(), resp)) return null;
        UserAccountDb affiliatedUser = userAccountRepository.findById(usr).orElse(null);
        if(affiliatedUser == null) return null;

        List<UserAccountDb> mem = entdb.getMembers();
        boolean useris_member = false;
        for(UserAccountDb udb : mem){
            if(udb.getId().equals(usr)){
                useris_member = true;
            }
        }
        if(useris_member == false) return null;
        //now if responsable user is found AND enterprise is found too AND user affiliated is found --> MODIFY USER
        UserAccountDb userAccountDb = userAccountJpaAdapterMapper.map(userAccount);
        affiliatedUser.setFirstname(userAccountDb.getFirstname());
        affiliatedUser.setLastname(userAccountDb.getLastname());
        affiliatedUser.setEmail(userAccountDb.getEmail());
        affiliatedUser = userAccountRepository.save(affiliatedUser);
        return userAccountJpaAdapterMapper.map(affiliatedUser);
    }

    @Override
    public boolean delete(Long resp, Long ent, Long usr) {
        UserAccountDb uad = userAccountRepository.findById(resp).orElse(null);
        if(uad == null) return false;
        EnterpriseDb entdb = enterpriseRepository.findById(ent).orElse(null);
        if(entdb == null) return false;
        if(!Objects.equals(entdb.getResponsableUser().getId(), resp)) return false;
        List<UserAccountDb> mem = entdb.getMembers();
        for(UserAccountDb udb : mem){
            if(udb.getId().equals(usr)){
                mem.remove(udb);
                entdb.setMembers(mem);
                enterpriseRepository.save(entdb);
                return true;
            }
        }
        return false;
    }
}
