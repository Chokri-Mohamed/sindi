package tech.byrsa.sindibad.enterprise.model;

import lombok.Data;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.useraccount.model.UserAccount;

import java.util.List;

@Data
public class Enterprise {

    private Long id;
    private String name;
    private String fiscalNum;
    private UserAccount responsableUser;
    private List<UserAccount> members;
    private List<Advert> adverts;
}
