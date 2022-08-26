package com.javatechie.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.batch.entity.Producto;

public interface ProductoRepository  extends JpaRepository<Producto,Integer> {
}
