package tech.byrsa.sindibad.database.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.byrsa.sindibad.enumerated.Gender;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccountDb extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Gender gender;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
	private List<AdvertDb> adverts;

}
