package tech.byrsa.sindibad.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import tech.byrsa.sindibad.database.entity.AnnonceDb;

public interface AnnonceRepository extends JpaRepository<AnnonceDb, Long>, JpaSpecificationExecutor<AnnonceDb>{

}
