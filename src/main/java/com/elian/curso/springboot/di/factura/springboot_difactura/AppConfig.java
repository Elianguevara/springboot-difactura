package com.elian.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;

import com.elian.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.elian.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {
    //@Primary
    @Bean(name = "default")
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony",800);
        Product p2 = new Product("Bicicleta Bianchi",1200);
        Product p3 = new Product("Camara Canon",600);
        return Arrays.asList(
            new Item(p1, 2),
            new Item(p2, 4),
            new Item(p3, 3)
        );
        
    }

    @Bean
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24",700);
        Product p2 = new Product("Notebook Razer",2400);
        Product p3 = new Product("Impresora HP",800);
        Product p4 = new Product("Escritorio Oficina",900);
        return Arrays.asList(
            new Item(p1, 4),
            new Item(p2, 6),
            new Item(p3, 1)
            ,new Item(p4, 4)
        );
        
    }

}
