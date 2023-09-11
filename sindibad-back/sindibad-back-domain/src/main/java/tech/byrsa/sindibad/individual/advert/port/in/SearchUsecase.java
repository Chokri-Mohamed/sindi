package tech.byrsa.sindibad.individual.advert.port.in;

import tech.byrsa.sindibad.individual.advert.model.Advert;

import java.util.List;

public interface SearchUsecase {
    List<Advert> search(String eq);
}
