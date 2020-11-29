package br.gov.pr.seed.swwantoniolisboa.inagro.controller

import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.Seed
import br.gov.pr.seed.swwantoniolisboa.inagro.service.RegionService
import br.gov.pr.seed.swwantoniolisboa.inagro.service.SeedService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/regions")
class RegionController(
        private val regionService: RegionService,
        private val seedService: SeedService
) {

    @GetMapping
    fun getAll() = regionService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: UUID) = regionService.getRegionById(id)

    @GetMapping("/{regionId}/seeds")
    fun getAll(@PathVariable("regionId") regionId: UUID): List<Seed> {
        val region = regionService.getRegionById(regionId)
        return seedService.getSeedsFromRegion(region)
    }

}