package com.LetsCode.Aula2Lambda.ExercicioEstacionamento;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EstacionamentoShopping implements Estacionamento {

    private List<Veiculo> veiculos;

    public EstacionamentoShopping() {
        this.veiculos = new ArrayList<>();
    }

    @Override
    public void entradaVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    @Override
    public void saidaVeiculo(String placa) {
        this.veiculos.forEach(v -> {
            if (v.getPlaca().equals(placa)) {
                v.saida(12.0);
            }
        });

        for (Veiculo veiculo: this.veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.saida(12.0);
            }
        }
    }

    @Override
    public void cobrar(Veiculo veiculo) {

    }

    @Override
    public void listarVeiculos() {
        for (Veiculo veiculo: this.veiculos) {
            System.out.println(veiculo);
        }
    }

    @Override
    public void listarVeiculoPorCategoria(Categoria categoria) {
        for (Veiculo veiculo: this.veiculos) {
            if (veiculo.getCategoria().equals(categoria)) {
                System.out.println(veiculo);
            }

        }
    }

    @Override
    public void listarVeiculoPorCategoriaDia(Categoria categoria) {
        var dataAtual = LocalDate.now();

        for (Veiculo veiculo: this.veiculos) {
            var dataEntrada = LocalDate.from(veiculo.getDataHoraEntrada());
            if (veiculo.getCategoria().equals(categoria) && dataEntrada.compareTo(dataAtual) == 0) {
                System.out.println(veiculo);
            }

        }
    }

    @Override
    public void listarVeiculoPorCategoriaPorPlaca(Categoria categoria) {
        var dataAtual = LocalDate.now();

        for (Veiculo veiculo: this.veiculos) {
            if (veiculo.getCategoria().equals(categoria) && veiculo.getPlaca().startsWith("ABC")) {
                System.out.println(veiculo);
            }

        }
    }

    @Override
    public void listarPorCategoria(Categoria categoria, PesquisaVeiculo pesquisaVeiculo) {
        for (Veiculo veiculo: this.veiculos) {
            if (pesquisaVeiculo.filtrar(veiculo, categoria)) {
                System.out.println(veiculo);
            }

        }
    }

    @Override
    public void retornaVeiculoValor(PesquisaVeiculoPreco pesquisaVeiculoPreco) {
        for (Veiculo veiculo: this.veiculos) {
            if (pesquisaVeiculoPreco.retornaSePreco(veiculo) > 10) {
                System.out.println(veiculo);
            }
        }
    }

    public void listar(Predicate<Veiculo> pesquisaVeiculoPreco) {
        for (Veiculo veiculo: this.veiculos) {
            if (pesquisaVeiculoPreco.test(veiculo)) {
                System.out.println(veiculo);
            }
        }
    }
}