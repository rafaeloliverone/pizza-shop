package br.edu.ifpb.padroes.domain.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class PanPizzaDecorator extends PizzaDecorator {

    public PanPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Float getPrice() {
        Float price = super.getPrice();
        return price *= 1.15f;
    }

    @Override
    public String getName() {
        return super.getName() + " (pan pizza)";
    }

}
