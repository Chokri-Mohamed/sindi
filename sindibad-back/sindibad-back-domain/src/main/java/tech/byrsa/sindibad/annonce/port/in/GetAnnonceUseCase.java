package tech.byrsa.sindibad.annonce.port.in;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tech.byrsa.sindibad.annonce.model.Annonce;

public interface GetAnnonceUseCase {
	Page<Annonce> getAnnonce(Pageable id);


}
