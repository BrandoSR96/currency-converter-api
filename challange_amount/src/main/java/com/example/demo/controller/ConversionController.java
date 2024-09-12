package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RespuestaConversion;
import com.example.demo.model.TasaCambio;
import com.example.demo.repository.TasaCambioRepository;

@RestController
@RequestMapping("/api")
public class ConversionController {

    @Autowired
    private TasaCambioRepository tasaCambioRepository;

    @GetMapping("/convertir")
    public RespuestaConversion convertir(@RequestParam double monto,
                                         @RequestParam String monedaOrigen,
                                         @RequestParam String monedaDestino) {
        TasaCambio tasa = tasaCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
        double montoConvertido = monto * tasa.getTasa();
        return new RespuestaConversion(monto, montoConvertido, monedaOrigen, monedaDestino, tasa.getTasa());
    }

    @PostMapping("/tasa")
    public void actualizarTasa(@RequestBody TasaCambio tasaCambio) {
        tasaCambioRepository.save(tasaCambio);
    }
}