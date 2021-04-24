package br.edu.ifpb.padroes.domain.decorators;

import br.edu.ifpb.padroes.domain.Pizza;

public class ChesseDecorator extends PizzaDecorator {

    public ChesseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public Float getPrice() {
        Float price = super.getPrice();
        return price *= 1.10f;
    }

    @Override
    public String getName() {
        return super.getName() + " (extra cheese)";
    }
}
