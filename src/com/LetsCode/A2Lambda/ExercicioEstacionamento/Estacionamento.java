package com.LetsCode.A2Lambda.ExercicioEstacionamento;
import java.util.function.Predicate;

public interface Estacionamento {
    void entradaVeiculo(Veiculo veiculo);
    void saidaVeiculo(String placa);
    void cobrar(Veiculo veiculo);
    void listarVeiculos();
    void listarVeiculoPorCategoria(Categoria categoria);
    void listarVeiculoPorCategoriaDia(Categoria categoria);
    void listarVeiculoPorCategoriaPorPlaca(Categoria categoria);
    void listarPorCategoria(Categoria categoria, PesquisaVeiculo pesquisaVeiculo);
    void retornaVeiculoValor(PesquisaVeiculoPreco pesquisaVeiculoPreco );
    void listar(Predicate<Veiculo> pesquisaVeiculoPreco);
}