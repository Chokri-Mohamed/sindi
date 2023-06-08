package tech.byrsa.sindibad.rest.controller.individual.advert;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.individual.advert.port.in.CreateAdvertUseCase;
import tech.byrsa.sindibad.individual.advert.port.in.GetDetailedAdvertQuery;
import tech.byrsa.sindibad.individual.advert.port.in.GetPaginatedAdvertsQuery;
import tech.byrsa.sindibad.individual.advert.port.in.UpdateAdvertUseCase;
import tech.byrsa.sindibad.rest.controller.AbstractController;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.CreateAdvertRequest;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.DetailedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.PaginatedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.UpdateAdvertRequest;
import tech.byrsa.sindibad.rest.controller.individual.advert.mapper.AdvertRestMapper;

@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AbstractController.INDIVIDUAL + "adverts")
public class IndividualAdvertRestController {

	private final GetDetailedAdvertQuery getDetailedAdvert;
	private final GetPaginatedAdvertsQuery getPaginatedAdverts;
	private final CreateAdvertUseCase createAdvert;
	private final UpdateAdvertUseCase updateAdvert;

	private final AdvertRestMapper advertRestMapper;

	@GetMapping
	public ResponseEntity<Page<PaginatedAdvertResponse>> getPaginatedAdvert(Pageable pageable) {

		log.entry(pageable);

		Page<Advert> advert = getPaginatedAdverts.getPaginatedAdverts(pageable);
		Page<PaginatedAdvertResponse> paginatedAdvertResponse = advert.map(advertRestMapper::mapToPaginatedAdvert);

		log.exit(paginatedAdvertResponse);

		return ResponseEntity.ok(paginatedAdvertResponse);
	}

	@GetMapping("{id}")
	public ResponseEntity<DetailedAdvertResponse> getDetailedAdvert(@PathVariable Long id) {

		log.entry(id);

		Advert advert = getDetailedAdvert.getDetailedAdvert(id);
		DetailedAdvertResponse detailedAdvertResponse = advertRestMapper.mapToDetailedAdvert(advert);

		log.exit(detailedAdvertResponse);

		return ResponseEntity.ok(detailedAdvertResponse);
	}

	@PostMapping
	public ResponseEntity<Long> createAdvert(CreateAdvertRequest createAdvertRequest, Long userId) {

		log.entry(createAdvertRequest);

		AdvertCreate advertCreate = advertRestMapper.map(createAdvertRequest, userId);
		Long id = createAdvert.createAdvert(advertCreate);

		log.exit(id);

		return ResponseEntity.ok(id);
	}

	@PatchMapping("{id}")
	public ResponseEntity<Long> updateAdvert(@PathVariable Long id, UpdateAdvertRequest updateAdvertRequest) {

		log.entry(id, updateAdvertRequest);

		AdvertUpdate advertUpdate = advertRestMapper.map(id, updateAdvertRequest);
		updateAdvert.updateAdvert(advertUpdate);

		log.exit(id);

		return ResponseEntity.ok(id);
	}
}
