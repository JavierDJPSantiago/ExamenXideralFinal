package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Producto;

import org.springframework.batch.item.ItemProcessor;

//El Processor se encargará de recibir un Producto y entregar un Producto por país
public class ProductoProcessor implements ItemProcessor<Producto,Producto> {

    @Override
    public Producto process(Producto producto) throws Exception {
        if(producto.getPais().equals("Japon")) {
            return producto;
        }
        return null;
        
    }
}
