package OperacaoLavaJato;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String veiculo;
    private String placa;
    private boolean agendamento;
    private double preco;
    private String statusLavagem;
    private boolean statusPagamento;
    private boolean statusCancelado;

    public boolean isStatusCancelado() {
        return statusCancelado;
    }

    public void setStatusCancelado(boolean statusCancelado) {
        this.statusCancelado = statusCancelado;
    }
    
    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getStatusLavagem() {
        return statusLavagem;
    }

    public void setStatusLavagem(String statusLavagem) {
        this.statusLavagem = statusLavagem;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isAgendamento() {
        return agendamento;
    }

    public void setAgendamento(boolean agendamento) {
        this.agendamento = agendamento;
    }

}    
