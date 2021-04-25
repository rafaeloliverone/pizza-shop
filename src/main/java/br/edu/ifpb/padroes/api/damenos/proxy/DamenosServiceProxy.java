package br.edu.ifpb.padroes.api.damenos.proxy;

import br.edu.ifpb.padroes.api.damenos.DamenosPizza;
import br.edu.ifpb.padroes.api.damenos.DamenosServiceImpl;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotPizza;
import br.edu.ifpb.padroes.api.pizzahot.PizzaHotServiceImpl;

import java.util.ArrayList;
import java.util.List;

// TODO - implementar proxy de cache para evitar leitura do json a cada chamada do método [X]
public class DamenosServiceProxy implements DamenosService {

    public DamenosServiceImpl daMenosService;
    public List<DamenosPizza> cachePizzas = new ArrayList<>();

    public DamenosServiceProxy(DamenosServiceImpl damenosServiceProxy) {
        this.daMenosService = damenosServiceProxy;
    }

    @Override
    public List<DamenosPizza> getPizzas() {
        // TODO - implementar proxy [X]
        if (this.cachePizzas.size() == 0) {
//            System.out.println("Cache vazio, retornando do service");
            this.cachePizzas = this.daMenosService.getPizzas();
        } else {
//            System.out.println("Dados vindo do cache");
        }

        return this.cachePizzas;
    }
}
