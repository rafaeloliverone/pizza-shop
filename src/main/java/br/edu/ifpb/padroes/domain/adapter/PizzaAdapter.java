package br.edu.ifpb.padroes.domain.adapter;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.proxy.DamenosService;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.proxy.PizzaHotService;
import br.edu.ifpb.padroes.domain.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaAdapter implements Pizza {

    private DamenosService damenosService;
    private PizzaHotService pizzaHotService;

    public PizzaAdapter(DamenosService menosService, PizzaHotService hotService) {
        damenosService = menosService;
        pizzaHotService = hotService;
    }

    public List<Pizza> getPizzas() {
        List<Pizza> allPizzas = new ArrayList<>();

        List<DamenosPizza> pizzasDaMenos = damenosService.getPizzas();
        List<PizzaHotPizza> pizzasHot = pizzaHotService.getPizzas();


        for (PizzaHotPizza pizza : pizzasHot) {
            allPizzas.add(new PizzahotAdapter(pizza));
        }
        for (DamenosPizza pizza : pizzasDaMenos) {
            allPizzas.add(new DamenosAdapter(pizza));
        }

        return allPizzas;
    }

    @Override
    public Float getPrice() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
