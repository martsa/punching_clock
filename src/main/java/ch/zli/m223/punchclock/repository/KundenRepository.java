package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Kunden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundenRepository extends JpaRepository<Kunden, Long> {
}
