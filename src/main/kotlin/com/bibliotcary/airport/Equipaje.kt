package com.bibliotcary.airport

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Equipaje(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var peso: Double,

    @Column(name = "numero_rastreo")
    var numeroRastreo: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pasajero_id")
    var pasajero: Pasajero,
) {
    constructor() : this(0, 1.0,"", Pasajero(0,"",""))
}
