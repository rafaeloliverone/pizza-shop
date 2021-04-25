package br.edu.ifpb.padroes.api.pizzahot.proxy;

import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;

import java.util.ArrayList;
import java.util.List;

// TODO - implementar proxy de cache para evitar leitura do json a cada chamada do método [X]
public class PizzaHotServiceProxy implements PizzaHotService {

    public PizzaHotServiceImpl hotService;
    public List<PizzaHotPizza> cachePizzas = new ArrayList<>();

    public PizzaHotServiceProxy(PizzaHotServiceImpl pizzaHotServiceProxy) {
        this.hotService = pizzaHotServiceProxy;
    }

    @Override
    public List<PizzaHotPizza> getPizzas() {
        // TODO - implementar proxy [X]
        if (this.cachePizzas.size() == 0) {
//            System.out.println("Cache vazio, retornando do service");
            this.cachePizzas = this.hotService.getPizzas();
        } else {
//            System.out.println("Dados vindo do cache");
        }

        return this.cachePizzas;
    }
}
