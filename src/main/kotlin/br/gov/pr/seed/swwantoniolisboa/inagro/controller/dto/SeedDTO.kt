package br.gov.pr.seed.swwantoniolisboa.inagro.controller.dto

import br.gov.pr.seed.swwantoniolisboa.inagro.model.region.State
import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.Season
import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.Seed

data class SeedDTO(
        val regionName: String,
        val regionState: State,
        val name: String,
        val type: String,
        val successRateBySeason: Map<Season, Int>,
        val currentSuccessRate: Int
) {

    companion object {
        fun of(seed: Seed) = SeedDTO(
                regionName = seed.region.name,
                regionState = seed.region.state,
                name = seed.name,
                type = seed.type,
                successRateBySeason = seed.successRateBySeason,
                currentSuccessRate = seed.getSuccessRateFromToday()
        )
    }

}