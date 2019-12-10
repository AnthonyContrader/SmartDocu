package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Version;

@Repository
@Transactional
public interface VersionRepository extends CrudRepository<Version, Long> {

}
