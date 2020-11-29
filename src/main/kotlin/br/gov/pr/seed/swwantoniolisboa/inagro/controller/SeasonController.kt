package br.gov.pr.seed.swwantoniolisboa.inagro.controller

import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.Season
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/seasons")
class SeasonController {

    @GetMapping("/current")
    fun getCurrentSeason() = Season.fromDate(LocalDate.now())

}