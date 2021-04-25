package br.edu.ifpb.padroes.service;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosServiceProxy;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotServiceProxy;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.adapter.PizzaAdapter;

import java.util.List;

public class PizzaShopService {
    public PizzaAdapter pizzaAdapter;

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    // TODO - alterar criação de instância para chamar para o Proxy de Cache [X]
    public PizzaShopService() {
        damenosService = new DamenosServiceProxy(new DamenosServiceImpl());
        pizzaHotService = new PizzaHotServiceProxy(new PizzaHotServiceImpl());
        pizzaAdapter = new PizzaAdapter(damenosService, pizzaHotService);
    }

    // TODO - implementar decorator para não precisar atributos da pizza como parâmetros no método [X]
    public void orderPizza(Pizza pizza) {
        Float totalPrice = pizza.getPrice();
        String name = pizza.getName();

        System.out.println(String.format("New order for = %s", name));
        System.out.println(String.format("Total price = %f", totalPrice));
    }

    // TODO - implementar adapter para unificar pizzas vindas das APIs Damenos e PizzaHot num único método getPizzas() [X]
    // TODO - public List<Pizza> getPizzas() {} [X]

    public List<Pizza> getPizzas() {
        return pizzaAdapter.getPizzas();
    }


}
