package tech.byrsa.sindibad.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "advert")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="advert_type",
		discriminatorType = DiscriminatorType.INTEGER)
public class AdvertDb extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccountDb.class)
	private UserAccountDb userAccount;

	@Column(insertable = false, updatable = false)
	private int advert_type;

}
