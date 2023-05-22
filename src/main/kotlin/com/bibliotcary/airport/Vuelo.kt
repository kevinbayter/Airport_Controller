package com.bibliotcary.airport

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Vuelo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "numero_vuelo")
    var numeroVuelo: String,

    @Column(name = "fecha_salida")
    var fechaSalida: LocalDateTime,

    @Column(name = "fecha_llegada")
    var fechaLlegada: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_origen_id")
    var aeropuertoOrigen: Aeropuerto,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aeropuerto_destino_id")
    var aeropuertoDestino: Aeropuerto,

) {
    constructor() : this(0,"", LocalDateTime.now(),  LocalDateTime.now(), Aeropuerto(), Aeropuerto())
}
