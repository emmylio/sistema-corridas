package model;

public class Corrida {

    private long id;
    private String enderecoDePartida;
    private String enderecoDeDestino;
    private Passageiro passageiro;

      public Corrida(){}

    public Corrida(String enderecoDePartida, String enderecoDeDestino, Passageiro passageiro) {
        this.id = System.currentTimeMillis();
        this.enderecoDePartida = enderecoDePartida;
        this.enderecoDeDestino = enderecoDeDestino;
        this.passageiro = passageiro;
    }
    

  public long getId() {
        return id;
    }

    public String getEnderecoDePartida() {
        return enderecoDePartida;
    }

    public String getEnderecoDeDestino() {
        return enderecoDeDestino;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

@Override
    public String toString() {
        String pronome = passageiro.getSexo().equalsIgnoreCase("FEMININO") ? "pegá-la" : "pegá-lo";
        return passageiro.getNome().split(" ")[0] + " pede para " + pronome + " em " + enderecoDePartida;
    }


}

