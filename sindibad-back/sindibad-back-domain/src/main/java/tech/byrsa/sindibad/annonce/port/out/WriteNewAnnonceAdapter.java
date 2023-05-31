package tech.byrsa.sindibad.annonce.port.out;

import tech.byrsa.sindibad.annonce.model.WriteNewAnnonce;

public interface WriteNewAnnonceAdapter {

	Long writeNewAnnonce(WriteNewAnnonce writeNewAnnonce);

}
