package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TasaCambio;

public interface TasaCambioRepository extends JpaRepository<TasaCambio, Long> {
    TasaCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}