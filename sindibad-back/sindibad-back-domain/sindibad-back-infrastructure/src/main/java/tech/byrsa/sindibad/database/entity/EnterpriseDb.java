package tech.byrsa.sindibad.database.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.byrsa.sindibad.enterprise.model.Enterprise;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "enterprise")
public class EnterpriseDb extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String fiscalNum;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = UserAccountDb.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "responsable_user_id")
    private UserAccountDb responsableUser;

    @OneToMany(fetch = FetchType.EAGER)
    private List<UserAccountDb> members;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AdvertDb> adverts;
}
