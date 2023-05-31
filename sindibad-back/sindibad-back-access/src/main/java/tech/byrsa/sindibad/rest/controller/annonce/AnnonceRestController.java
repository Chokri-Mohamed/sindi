package tech.byrsa.sindibad.rest.controller.annonce;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tech.byrsa.sindibad.annonce.model.Annonce;
import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;
import tech.byrsa.sindibad.annonce.port.in.GetAnnonceUseCase;
import tech.byrsa.sindibad.annonce.port.in.WriteNewAnnonceUseCase;
import tech.byrsa.sindibad.rest.controller.annonce.dto.request.WriteNewAnnonceRequest;
import tech.byrsa.sindibad.rest.controller.annonce.dto.response.GetAnnonceResponse;
import tech.byrsa.sindibad.rest.controller.annonce.mapper.AnnonceRestMapper;

@RestController
@RequestMapping("annonce")
@AllArgsConstructor
public class AnnonceRestController {
	private AnnonceRestMapper annonceRestMapper;
	private GetAnnonceUseCase getAnnonceUseCase;
	private WriteNewAnnonceUseCase writeNewAnnonce;

	@PostMapping
	public ResponseEntity<Long> addAnnounce(final @RequestBody WriteNewAnnonceRequest writeNewAnnounceRequest) {
		final WriteNewAnnonce writeNewAnnounce = annonceRestMapper.map(writeNewAnnounceRequest);
		Long id = writeNewAnnonce.writeNewAnnonce(writeNewAnnounce);
		return ResponseEntity.ok(id);
	}

	@GetMapping
	public ResponseEntity<GetAnnonceResponse> getAnnonce(@PathVariable final Pageable id) {
		final Page<Annonce> annonce = getAnnonceUseCase.getAnnonce(id);
		final GetAnnonceResponse getAnnonceResponse = annonceRestMapper.map(annonce);
		return ResponseEntity.ok(getAnnonceResponse);
	}
}
