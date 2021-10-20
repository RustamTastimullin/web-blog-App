package ru.springapp.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ru.springapp.blog.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
