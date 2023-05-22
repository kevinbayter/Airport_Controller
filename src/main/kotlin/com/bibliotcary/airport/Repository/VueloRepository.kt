package com.bibliotcary.airport.Repository

import com.bibliotcary.airport.Vuelo
import org.springframework.data.jpa.repository.JpaRepository

interface VueloRepository : JpaRepository<Vuelo, Long>
