package br.gov.pr.seed.swwantoniolisboa.inagro.service

import br.gov.pr.seed.swwantoniolisboa.inagro.infrastructure.SeedNotFoundException
import br.gov.pr.seed.swwantoniolisboa.inagro.model.region.Region
import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.SeedRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SeedService(private val seedRepository: SeedRepository) {

    fun getSeedsFromRegion(region: Region) = seedRepository.findAllByRegion(region)

    fun getById(id: UUID) = seedRepository.findById(id)
            .orElseThrow { SeedNotFoundException("Seed $id not found.") }

}