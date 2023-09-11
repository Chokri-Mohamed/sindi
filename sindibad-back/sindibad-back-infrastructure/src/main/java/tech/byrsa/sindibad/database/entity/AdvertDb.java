package tech.byrsa.sindibad.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Indexed;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Document(indexName = "advert", type="advertDB")
@Table(name = "advert")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="advert_type",
		discriminatorType = DiscriminatorType.INTEGER)
public class AdvertDb extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Field(type = FieldType.Text, name = "title")
	private String title;
	@Field(type = FieldType.Text, name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccountDb.class)
	private UserAccountDb userAccount;

	@Column(insertable = false, updatable = false)
	private int advert_type;

}
