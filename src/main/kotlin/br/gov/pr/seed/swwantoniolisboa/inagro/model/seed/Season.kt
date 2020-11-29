package br.gov.pr.seed.swwantoniolisboa.inagro.model.seed

import java.time.LocalDate

enum class Season {
    SUMMER, FALL, WINTER, SPRING;

    companion object {
        fun fromDate(date: LocalDate) = when {
            date.isDuringTheSummer() -> SUMMER
            date.isDuringTheFall() -> FALL
            date.isDuringTheWinter() -> WINTER
            else -> SPRING
        }

        private fun LocalDate.isDuringTheSummer(): Boolean {
            val day = this.dayOfMonth
            val month = this.month.value
            return (day >= 21 && month == 12) || (month < 3) || ( day < 20 && month == 3)
        }

        private fun LocalDate.isDuringTheFall(): Boolean {
            val day = this.dayOfMonth
            val month = this.month.value
            return (day >= 20 && month == 3) || (month < 6) || (day < 21 && month == 6)
        }

        private fun LocalDate.isDuringTheWinter(): Boolean {
            val day = this.dayOfMonth
            val month = this.month.value
            return (day >= 21 && month == 6) || (month < 9) || (day < 23 && month == 9)
        }
    }

}