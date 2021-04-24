package br.edu.ifpb.padroes.domain.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class PizzaDecorator implements Pizza {

    private Pizza wrapper;

    public PizzaDecorator(Pizza pizza) {
        this.wrapper = pizza;
    }

    @Override
    public Float getPrice() {
        return wrapper.getPrice();
    }

    @Override
    public String getName() {
        return wrapper.getName();
    }
}
