package tech.byrsa.sindibad.enterprise.port.out;

import tech.byrsa.sindibad.enterprise.model.Enterprise;

public interface SaveEntreprise {

    Enterprise handle(Enterprise enterprise);
}
