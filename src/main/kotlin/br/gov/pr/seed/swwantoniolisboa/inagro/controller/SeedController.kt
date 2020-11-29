package br.gov.pr.seed.swwantoniolisboa.inagro.controller

import br.gov.pr.seed.swwantoniolisboa.inagro.controller.dto.SeedDTO
import br.gov.pr.seed.swwantoniolisboa.inagro.service.SeedService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/seeds")
class SeedController(private val seedService: SeedService) {

    @GetMapping("/{id}")
    fun getAll(@PathVariable("id") id: UUID): SeedDTO {
        val seed = seedService.getById(id)
        return SeedDTO.of(seed)
    }

}