package com.elian.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
@SessionScope
@JsonIgnoreProperties({"targetSource","advisors", "targetClass", "proxyTargetClass", "staticPart", "this$0"})
public class Invoice {


    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;
    @Autowired
    @Qualifier("default")
    private List <Item> items;

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" Pepe"));
        description = description.concat(" del cliente").concat(client.getName().concat(" ").concat(client.getLastname()));
        
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente de la factura");
        
    }

    public Invoice() {
    }
    public Invoice(Client client, String description, List<Item> items) {
        this.client = client;
        this.description = description;
        this.items = items;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return items.stream().mapToInt(Item::getImporte).sum();
    }
    
}
