package tech.byrsa.sindibad.rest.controller.enterprise;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.byrsa.sindibad.enterprise.model.Enterprise;
import tech.byrsa.sindibad.enterprise.port.in.AffiliateEnterprise;
import tech.byrsa.sindibad.enterprise.port.in.CreateEntrepriseUseCase;
import tech.byrsa.sindibad.enterprise.port.in.GetOneEnterpriseUseCase;
import tech.byrsa.sindibad.enterprise.port.in.ModifyEnterpriseUseCase;
import tech.byrsa.sindibad.enterprise.port.out.GetOneEnterprise;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.rest.controller.AbstractController;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.PaginatedAdvertResponse;
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

    @PatchMapping("/affiliate/{responsable_id}/{ent_id}")
    public ResponseEntity<String> affiliate(@PathVariable("responsable_id") Long responsable_id, @PathVariable("ent_id") Long ent_id, @RequestBody CreateUserAccountRequest createUserAccountRequest) {
        UserAccountCreate userAccountCreate = userAccountRestMapper.map(createUserAccountRequest);
        String e = affiliateEnterprise.affiliate(responsable_id, ent_id, userAccountCreate);
        if (e == null) return ResponseEntity.status(404).body(null);
        return ResponseEntity.ok(e);
    }
}
