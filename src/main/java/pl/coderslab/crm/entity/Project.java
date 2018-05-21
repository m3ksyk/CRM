package pl.coderslab.crm.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Project {
//    data utworzenia – nadawana automatycznie,
//            nazwa,
//            opis,
//    strona www – walidacja poprawności,
//    identyfikator – pole nadawane automatycznie tworzone przez usunięcie wszystkich znaków
//    diakrytycznych, np. (ółą) z pola nazwa oraz zastąpienie wszystkich białych znaków znakiem
//            myślnika,
//    użytkownicy – może być wielu, połączenie z encją użytkowników,
//    aktywność – pole boolean – dla projektów nieaktywnych nie wyświetlamy informacji na liście
//    aktywności.
}
