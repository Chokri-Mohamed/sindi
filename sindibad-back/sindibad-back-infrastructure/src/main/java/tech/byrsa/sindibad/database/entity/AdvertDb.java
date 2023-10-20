package tech.byrsa.sindibad.database.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Document(indexName = "advert", type = "advertDB")
@Table(name = "advert")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "advert_type", discriminatorType = DiscriminatorType.INTEGER)
public class AdvertDb extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Field(type = FieldType.Text, name = "title")
	private String title;
	@Field(type = FieldType.Text, name = "description")
	private String description;
	@Field(type = FieldType.Text, name = "gouvernorat")
	private String gouvernorat;
	private float lon;
	private float lat;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccountDb.class)
	private UserAccountDb userAccount;

	@Column(insertable = false, updatable = false)
	private int advert_type;

}
