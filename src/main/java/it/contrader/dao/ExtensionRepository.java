package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Extension;

@Repository
@Transactional
public interface ExtensionRepository extends CrudRepository<Extension, Long> {

}
