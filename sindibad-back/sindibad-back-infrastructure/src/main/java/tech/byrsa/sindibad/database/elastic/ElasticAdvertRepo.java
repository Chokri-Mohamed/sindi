package tech.byrsa.sindibad.database.elastic;

import netscape.javascript.JSObject;
import org.h2.util.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tech.byrsa.sindibad.database.entity.AdvertDb;

public interface ElasticAdvertRepo extends ElasticsearchRepository<AdvertDb, Long>, CrudRepository<AdvertDb, Long> {
    //@Query(value = "{\"query\": {\"wildcard\": {\"description\" : \"*?0*\"}}}", nativeQuery = true)
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"description\" : {\"query\" : \"*?0*\",\"analyze_wildcard\" : true}}}}}")
    Page<AdvertDb> findByDescriptionContaining(String name, Pageable pageable);
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"title\" : {\"query\" : \"*?0*\",\"analyze_wildcard\" : true}}}}}")
    Page<AdvertDb> findByTitleContaining(String name, Pageable pageable);
}

