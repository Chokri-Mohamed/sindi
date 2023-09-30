package tech.byrsa.sindibad.database.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
