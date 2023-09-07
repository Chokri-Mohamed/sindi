package tech.byrsa.sindibad.rest.controller.enterprise;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.in.*;
import tech.byrsa.sindibad.rest.controller.AbstractController;
import tech.byrsa.sindibad.rest.controller.userAccount.dto.CreateUserAccountRequest;
import tech.byrsa.sindibad.rest.controller.userAccount.mapper.UserAccountRestMapper;
import tech.byrsa.sindibad.useraccount.model.UserAccount;
import tech.byrsa.sindibad.useraccount.model.UserAccountCreate;

@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AbstractController.INDIVIDUAL + "enterprise")
public class EnterpriseRestController {

    private final CreateEntrepriseUseCase entrepriseUseCase;
    private final ModifyEnterpriseUseCase modifyEnterpriseUseCase;
    private final GetOneEnterpriseUseCase getOneEnterprise;
    private final AffiliateEnterprise affiliateEnterprise;
    private final DeleteEnterpriseUseCase deleteEnterpriseUseCase;
    private final DeleteUserEnterpriseUseCase deleteUserEnterpriseUseCase;
    private final ModUserEnterpriseUseCase modUserEnterprise;
    private final UserAccountRestMapper userAccountRestMapper;

    @PostMapping("/{resposable_id}")
    public ResponseEntity<Enterprise> create(@PathVariable("resposable_id") Long responsable_id, @RequestBody Enterprise enterprise) {

        log.entry(enterprise);

        Enterprise enterprise1 = entrepriseUseCase.add(responsable_id, enterprise);
        if (enterprise1 == null) return ResponseEntity.status(404).body(null);
        log.exit(enterprise1);

        return ResponseEntity.ok(enterprise1);
    }

    @PutMapping("/{resposable_id}/{enter_id}")
    public ResponseEntity<Enterprise> mod(@PathVariable("resposable_id") Long responsable_id, @PathVariable("enter_id") Long ent_id, @RequestBody Enterprise enterprise) {

        log.entry(enterprise);

        Enterprise enterprise1 = modifyEnterpriseUseCase.mod(responsable_id, ent_id, enterprise);
        if (enterprise1 == null) return ResponseEntity.status(404).body(null);
        log.exit(enterprise1);

        return ResponseEntity.ok(enterprise1);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Enterprise> get(@PathVariable("id") Long id) {
        Enterprise e = getOneEnterprise.one(id);
        if (e == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{responsable_id}/{ent_id}")
    public ResponseEntity<Boolean> delete(@PathVariable("responsable_id") Long responsable_id, @PathVariable("ent_id") Long ent_id) {
        boolean e = deleteEnterpriseUseCase.delete(responsable_id, ent_id);
        if (!e) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(e);
    }
    @PatchMapping("/affiliate/{responsable_id}/{ent_id}")
    public ResponseEntity<String> affiliate(@PathVariable("responsable_id") Long responsable_id, @PathVariable("ent_id") Long ent_id, @RequestBody CreateUserAccountRequest createUserAccountRequest) {
        UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
        String e = affiliateEnterprise.affiliate(responsable_id, ent_id, userAccountCreate);
        if (e == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(e);
    }
    @PutMapping("/users/{responsable_id}/{enter_id}/{user_id}")
    public ResponseEntity<UserAccount> mod(@PathVariable("responsable_id") Long responsable_id, @PathVariable("enter_id") Long ent_id, @PathVariable("user_id") Long user_id, @RequestBody UserAccount useraccount) {

        UserAccount us = modUserEnterprise.modify(responsable_id, ent_id, user_id, useraccount);
        if (us == null) return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(us);
    }

    @DeleteMapping("/users/{responsable_id}/{enter_id}/{user_id}")
    public ResponseEntity<Boolean> mod(@PathVariable("responsable_id") Long responsable_id, @PathVariable("enter_id") Long ent_id, @PathVariable("user_id") Long user_id) {

        boolean us = deleteUserEnterpriseUseCase.delete(responsable_id, ent_id, user_id);
        if (us == false) return ResponseEntity.status(404).body(null);

        return ResponseEntity.ok(us);
    }
}
