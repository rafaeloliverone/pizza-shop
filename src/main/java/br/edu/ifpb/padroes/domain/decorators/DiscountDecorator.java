package br.edu.ifpb.padroes.domain.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class DiscountDecorator extends PizzaDecorator{

    public DiscountDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Float getPrice() {
        Float priceSuper = super.getPrice();
        return priceSuper *= 0.25f;
    }

}
