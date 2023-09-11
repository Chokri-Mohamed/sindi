package tech.byrsa.sindibad.individual.advert.port.out;

import tech.byrsa.sindibad.individual.advert.model.Advert;

import java.util.List;

public interface SearchAdvert {
    List<Advert> search(String eq);
}
