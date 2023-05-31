package tech.byrsa.sindibad.adapter.annonce;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import tech.byrsa.sindibad.annonce.model.Annonce;
import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;
import tech.byrsa.sindibad.annonce.port.out.GetAnnonceAdapter;
import tech.byrsa.sindibad.annonce.port.out.WriteNewAnnonceAdapter;
import tech.byrsa.sindibad.database.entity.AnnonceDb;
import tech.byrsa.sindibad.database.repository.AnnonceRepository;

@Component
@AllArgsConstructor
public class AnnonceJpaAdapter implements WriteNewAnnonceAdapter, GetAnnonceAdapter {
	private AnnonceRepository annonceRepository;
	private AnnonceDbMapper annonceDbMapper;

	@Override
	@Transactional
	public Long writeNewAnnonce(WriteNewAnnonce newAnnonce) {
		final AnnonceDb annonceDb = annonceDbMapper.map(newAnnonce);
		final AnnonceDb createdAnnonceDb = annonceRepository.save(annonceDb);

		return createdAnnonceDb.getId();
	}

	@Override
	public Page<Annonce> getAnnonce(Pageable id) {
		final Page<AnnonceDb> pageAnnonceDb = annonceRepository.findAll(id);
		return pageAnnonceDb.map(annonceDb -> annonceDbMapper.mapa(annonceDb)) ;
	}

}
