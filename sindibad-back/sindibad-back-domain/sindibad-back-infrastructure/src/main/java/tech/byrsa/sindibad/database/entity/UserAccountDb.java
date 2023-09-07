package tech.byrsa.sindibad.database.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.byrsa.sindibad.enterprise.model.Enterprise;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="user_account",schema="sindibad")
public class UserAccountDb extends AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String password;
	private String firstname;
	private String lastname;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
	private List<AdvertDb> adverts;

}
