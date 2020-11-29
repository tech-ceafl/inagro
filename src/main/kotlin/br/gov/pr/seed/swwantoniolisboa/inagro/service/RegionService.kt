package br.gov.pr.seed.swwantoniolisboa.inagro.service

import br.gov.pr.seed.swwantoniolisboa.inagro.infrastructure.RegionNotFoundException
import br.gov.pr.seed.swwantoniolisboa.inagro.model.region.RegionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegionService(private val repository: RegionRepository) {

    fun getAll() = repository.findAll()

    fun getRegionById(regionId: UUID) = repository.findById(regionId)
            .orElseThrow { RegionNotFoundException("Region $regionId not found.") }

}