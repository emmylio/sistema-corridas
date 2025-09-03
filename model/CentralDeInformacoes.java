package model;

import java.util.ArrayList;

public class CentralDeInformacoes {

    private ArrayList<Passageiro> todosOsPassageiros;

    public CentralDeInformacoes() {
        this.todosOsPassageiros = new ArrayList<>();
    }

    // retornar todos os passageiros 
    public ArrayList<Passageiro> getTodosOsPassageiros() {
        return todosOsPassageiros;
    }


     public void setTodosOsPassageiros(ArrayList<Passageiro> todosOsPassageiros) {
    this.todosOsPassageiros = todosOsPassageiros;
   }


   public boolean adicionarPassageiro(Passageiro p) {
    for (Passageiro existente : todosOsPassageiros) {
        if (existente.getEmail().equalsIgnoreCase(p.getEmail())) {
            return false; // email já existe
        }
    }
  

    // validar idade
    if (p.getIdade() < 18) {
        return false; // menor de idade
    }

    todosOsPassageiros.add(p);
    return true;
}

public Passageiro recuperarPassageiroPeloEmail(String email) {
    for (Passageiro p : todosOsPassageiros){
        if (p.getEmail().equalsIgnoreCase(email)) {
            return p;
        }
    }
    return null;
}

//CORRIDA
private ArrayList<Corrida> todasAsCorridas = new ArrayList<>();

public boolean adicionarCorrida(Corrida corrida) {
    for (Corrida c : todasAsCorridas) {
        if (c.getId() == corrida.getId()) {
            return false;
        }
    }
    todasAsCorridas.add(corrida);
    return true;
}

public Corrida recuperarCorridaPeloId(long id) {
    for (Corrida c : todasAsCorridas) {
        if (c.getId() == id) {
            return c;
        }
    }
    return null;
}

public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) {
    ArrayList<Corrida> corridasDoPassageiro = new ArrayList<>();
    Passageiro p = recuperarPassageiroPeloEmail(email);

    if (p == null) {
        return null; // passageiro não existe
    }

    for (Corrida c : todasAsCorridas) {
        if (c.getPassageiro().getEmail().equalsIgnoreCase(email)) {
            corridasDoPassageiro.add(c);
        }
    }

    return corridasDoPassageiro;
}





}
