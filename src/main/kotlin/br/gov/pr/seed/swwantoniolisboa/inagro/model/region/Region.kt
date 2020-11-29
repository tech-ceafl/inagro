package br.gov.pr.seed.swwantoniolisboa.inagro.model.region

import br.gov.pr.seed.swwantoniolisboa.inagro.model.seed.Seed
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "region")
data class Region(
        @Id
        @Column(name = "id", nullable = false, unique = true)
        val id: UUID,
        @Column(name = "name", nullable = false)
        val name: String,
        @Enumerated(value = EnumType.STRING)
        @Column(name = "state", nullable = false)
        val state: State,
        @OneToMany(mappedBy = "region", cascade = [CascadeType.ALL])
        val seeds: List<Seed> = listOf()
)