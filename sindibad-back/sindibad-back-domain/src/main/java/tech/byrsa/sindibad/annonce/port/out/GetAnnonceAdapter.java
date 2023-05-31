package tech.byrsa.sindibad.annonce.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tech.byrsa.sindibad.annonce.model.Annonce;

public interface GetAnnonceAdapter {
	Page<Annonce> getAnnonce(Pageable id);

}
