package ru.springapp.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.springapp.blog.models.Zakupki;

public interface ReestrZakupokRepository extends CrudRepository<Zakupki, Long> {
}
