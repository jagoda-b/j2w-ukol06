package cz.czechitas.java2webapps.ukol6.service;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VizitkaService {
    private final List<Vizitka> seznamVizitek = new ArrayList<>();

    public VizitkaService() {
        seznamVizitek.add(
                new Vizitka(
                        "Dita (Přikrylová) Formánková",
                        "Czechitas z. s.",
                        "Václavské náměstí 837/11",
                        "Praha 1",
                        "11000",
                        "dita@czechitas.cs",
                        "+420 800123456",
                        "www.czechitas.cz"
                )
        );
        seznamVizitek.add(
                new Vizitka(
                        "Barbora Bühnová",
                        "Czechitas z. s.",
                        "Škrobárenská 511/3",
                        "Brno",
                        "61700",
                        null,
                        "+420 800123456",
                        "www.czechitas.cz"
                )
        );
        seznamVizitek.add(
                new Vizitka(
                        "Monika Ptáčníková",
                        "Czechitas z. s.",
                        "Technologická 372/2",
                        "Ostrava-Pustkovec",
                        "70800",
                        "monika@czechitas.cs",
                        "+420 800123456",
                        "www.czechitas.cz"
                )
        );
        seznamVizitek.add(
                new Vizitka(
                        "Mirka Zatloukalová",
                        "Czechitas z. s.",
                        "Vavrečkova 5262",
                        "Zlín",
                        "76001",
                        "mirka@czechitas.cs",
                        null,
                        "www.czechitas.cz"
                )
        );
        seznamVizitek.add(
                new Vizitka(
                        "Ondřej Čejka",
                        "Czechitas z. s.",
                        "Jungmannova 3",
                        "Olomouc",
                        "77900",
                        null,
                        null,
                        "www.czechitas.cz"
                )
        );
        seznamVizitek.add(
                new Vizitka(
                        "Kateřina Reiglová",
                        "Czechitas z. s.",
                        "Lipová 1789/9",
                        "České Budějovice",
                        "37005",
                        null,
                        null,
                        "www.czechitas.cz"
                )
        );
    }

    public List<Vizitka> getAll() {
        return seznamVizitek;
    }

    public Vizitka getById(int id) {
       try {
           return seznamVizitek.get(id);
       } catch (IndexOutOfBoundsException e) {
           throw new IllegalArgumentException("Invalid ID: " + id, e);
       }
    }

    public void add(Vizitka form) {
        seznamVizitek.add(form);
    }

    public void delete(int id) {
        seznamVizitek.remove(id);
    }
}
