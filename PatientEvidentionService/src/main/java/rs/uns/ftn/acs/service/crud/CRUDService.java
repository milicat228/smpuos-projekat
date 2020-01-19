package rs.uns.ftn.acs.service.crud;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.uns.ftn.acs.exceptions.ResourceNotFoundException;

public abstract class CRUDService<T, ID extends Serializable> {
	protected JpaRepository<T, ID> repo;

	public CRUDService(JpaRepository<T, ID> repo) {
		this.repo = repo;
	}

	public Page<T> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public T findOne(ID id) throws ResourceNotFoundException {
		Optional<T> optionalUser = repo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		throw new ResourceNotFoundException(id.toString());
	}

	public T save(T entity) {
		return repo.save(entity);
	}

	public T update(ID id, T newEntity) throws ResourceNotFoundException {
		T entity = findOne(id);
		BeanUtils.copyProperties(newEntity, entity, "id");
		return save(entity);
	}
	
	public void delete(ID id) throws ResourceNotFoundException {
		T entity = findOne(id);
		repo.delete(entity);
	}
}
