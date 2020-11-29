package br.gov.pr.seed.swwantoniolisboa.inagro.model.seed

import br.gov.pr.seed.swwantoniolisboa.inagro.infrastructure.SuccessRateBySeasonNotFoundException
import br.gov.pr.seed.swwantoniolisboa.inagro.model.region.Region
import com.fasterxml.jackson.annotation.JsonIgnore
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "seed")
@TypeDefs(
        TypeDef(name = "json", typeClass = JsonStringType::class),
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
data class Seed (
        @Id
        @Column(name = "id", nullable = false, unique = true)
        val id: UUID,
        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "region_id")
        val region: Region,
        @Column(name = "name", nullable = false)
        val name: String,
        @Column(name = "type", nullable = false)
        val type: String,
        @Type(type = "json")
        @Column(columnDefinition = "json", name = "success_rate_by_season", nullable = false)
        val successRateBySeason: Map<Season, Int>
) {

    fun getSuccessRateFromToday(): Int {
        val today = LocalDate.now()
        val currentSeason = Season.fromDate(today)
        return successRateBySeason[currentSeason]
                ?: throw SuccessRateBySeasonNotFoundException("Success rate by season $currentSeason not found.")
    }

}