package tech.byrsa.sindibad.database.specification;

import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.database.entity.AdvertDb;
import tech.byrsa.sindibad.database.entity.AdvertDb_;

@XSlf4j
@Component
public class AdvertSpecification {

	public static Specification<AdvertDb> byId(final Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(AdvertDb_.id), id);
	}

}
