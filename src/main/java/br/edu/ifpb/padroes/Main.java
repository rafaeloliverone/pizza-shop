package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.domain.Pizza;
import br.edu.ifpb.padroes.domain.PizzaShopPizza;
import br.edu.ifpb.padroes.domain.decorators.*;
import br.edu.ifpb.padroes.service.PizzaShopService;

public class Main {

    public static void main(String[] args) {

        PizzaShopService pizzaShopService = new PizzaShopService();

        System.out.println("Pizzas - menu");

        // TODO - implementar adapter para juntar as pizzas da PizzaHot e Damenos em um único conjunto [X]
        for (Pizza pizza : pizzaShopService.getPizzas()) {
            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getPrice()));
        }

        Pizza pizza = new PizzaShopPizza("pepperoni", 55.0f);

        PizzaDecorator pizzaDecorator = new DiscountDecorator(
            new ChesseDecorator(
                new StuffedCrustDecorator(
                    new PizzaDecorator(pizza)
                )
            )
        );

        // TODO - implementar padrão decorator para só precisar passar o objeto pizza [X]
        pizzaShopService.orderPizza(pizzaDecorator);
    }

}
