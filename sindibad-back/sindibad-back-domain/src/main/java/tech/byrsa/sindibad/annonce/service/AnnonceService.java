package tech.byrsa.sindibad.annonce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tech.byrsa.sindibad.annonce.model.Annonce;
import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;
import tech.byrsa.sindibad.annonce.port.in.GetAnnonceUseCase;
import tech.byrsa.sindibad.annonce.port.in.WriteNewAnnonceUseCase;
import tech.byrsa.sindibad.annonce.port.out.GetAnnonceAdapter;
import tech.byrsa.sindibad.annonce.port.out.WriteNewAnnonceAdapter;

@Service
@RequiredArgsConstructor
public class AnnonceService implements WriteNewAnnonceUseCase, GetAnnonceUseCase {

	private final WriteNewAnnonceAdapter writeNewAnnonceAdapter;
	private final GetAnnonceAdapter getAnnonceAdapter;
	@Override
	public Long writeNewAnnonce(WriteNewAnnonce writeNewAnnonce) {
		return writeNewAnnonceAdapter.writeNewAnnonce(writeNewAnnonce);
	}

	@Override
	public Page<Annonce> getAnnonce(Pageable id) {
		return getAnnonceAdapter.getAnnonce(id) ;
	}

}
