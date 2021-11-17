package com.starter.reto.Endpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;


import io.micrometer.core.instrument.Counter;

@Component
@Endpoint
public class Endpoint {
	
	private List<String> listaEstados = Arrays.asList("Open","Half-Open","Close");
	
	private Counter counter;
	
	@ReadOperation
	public List<String> verEstados(){
		counter.increment();
		return listaEstados;
	}
	
	@WriteOperation
	public void añadirEstado(@Selector String nuevoEstado) {
		counter.increment();
		listaEstados.add(nuevoEstado);
	}
	
	@DeleteOperation
	public void cancelarEstado(@Selector String estado) {
		counter.increment();
		listaEstados.remove(estado);
	}

}
