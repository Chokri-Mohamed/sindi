package tech.byrsa.sindibad.rest.controller.individual.advert;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import tech.byrsa.sindibad.individual.advert.model.Advert;
import tech.byrsa.sindibad.individual.advert.model.AdvertCreate;
import tech.byrsa.sindibad.individual.advert.model.AdvertUpdate;
import tech.byrsa.sindibad.individual.advert.port.in.*;
import tech.byrsa.sindibad.rest.controller.AbstractController;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.CreateAdvertRequest;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.DetailedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.PaginatedAdvertResponse;
import tech.byrsa.sindibad.rest.controller.individual.advert.dto.UpdateAdvertRequest;
import tech.byrsa.sindibad.rest.controller.individual.advert.mapper.AdvertRestMapper;

import java.util.Optional;

@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(AbstractController.INDIVIDUAL + "adverts")
public class IndividualAdvertRestController {

	private final GetDetailedAdvertQuery getDetailedAdvert;
	private final GetPaginatedAdvertsQuery getPaginatedAdverts;
	private final CreateAdvertUseCase createAdvert;
	private final UpdateAdvertUseCase updateAdvert;
	private final DeleteAdvertUseCase deleteAdvert;

	private final AdvertRestMapper advertRestMapper;

	@GetMapping
	public ResponseEntity<Page<PaginatedAdvertResponse>> getPaginatedAdvert(@RequestParam("pageSize") Optional<Integer> size, @RequestParam("pageNum") Optional<Integer> pagenumber) {

		//log.entry(pageable);
		int s = size.orElse(20);
		int p = pagenumber.orElse(0);

		Page<Advert> advert = getPaginatedAdverts.getPaginatedAdverts(PageRequest.of(p, s));
		Page<PaginatedAdvertResponse> paginatedAdvertResponse = advert.map(advertRestMapper::mapToPaginatedAdvert);

		log.exit(paginatedAdvertResponse);

		return ResponseEntity.ok(paginatedAdvertResponse);
	}

	@GetMapping("{id}")
	public ResponseEntity<DetailedAdvertResponse> getDetailedAdvert(@PathVariable Long id) {

		log.entry(id);

		Advert advert = getDetailedAdvert.getDetailedAdvert(id);
		DetailedAdvertResponse detailedAdvertResponse = advertRestMapper.mapToDetailedAdvert(advert);
		if(advert == null) return ResponseEntity.status(404).body(detailedAdvertResponse);

		log.exit(detailedAdvertResponse);

		return ResponseEntity.ok(detailedAdvertResponse);
	}

	@PostMapping
	public ResponseEntity<Long> createAdvert(@RequestBody CreateAdvertRequest createAdvertRequest, @RequestParam("user") Long userId) {

		log.entry(createAdvertRequest);

		AdvertCreate advertCreate = advertRestMapper.map(createAdvertRequest, userId);
		Long id = createAdvert.createAdvert(advertCreate);

		log.exit(id);

		return ResponseEntity.ok(id);
	}

	@PatchMapping("{id}")
	public ResponseEntity<AdvertUpdate> updateAdvert(@PathVariable Long id, @RequestBody UpdateAdvertRequest updateAdvertRequest) {

		log.entry(id, updateAdvertRequest);

		AdvertUpdate advertUpdate = advertRestMapper.map(id, updateAdvertRequest);
		Advert ad = updateAdvert.updateAdvert(advertUpdate);

		if(ad == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		log.exit(id);
		return ResponseEntity.ok(advertRestMapper.map(ad));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		deleteAdvert.delete(id);
		return ResponseEntity.ok("Done");
	}
}
