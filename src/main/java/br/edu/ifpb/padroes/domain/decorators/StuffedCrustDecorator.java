package br.edu.ifpb.padroes.domain.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class StuffedCrustDecorator extends PizzaDecorator{

    public StuffedCrustDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Float getPrice() {
        Float price = super.getPrice();
        return price *= 1.20f;
    }

    @Override
    public String getName() {
        return super.getName() + " (stuffed crust)";
    }
}
