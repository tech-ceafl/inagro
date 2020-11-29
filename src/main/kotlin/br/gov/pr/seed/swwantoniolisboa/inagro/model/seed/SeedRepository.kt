package br.gov.pr.seed.swwantoniolisboa.inagro.model.seed

import br.gov.pr.seed.swwantoniolisboa.inagro.model.region.Region
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SeedRepository: JpaRepository<Seed, UUID> {

    fun findAllByRegion(region: Region): List<Seed>

}