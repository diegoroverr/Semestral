interface EstrategiaCalculoRisco {
    void calcularRisco(double patrimonio, double rendaMensal);
}


class ModeloConservador implements EstrategiaCalculoRisco {
    @Override
    public void calcularRisco(double patrimonio, double rendaMensal) {
        System.out.println("--- Analisando via Modelo CONSERVADOR ---");
        // Exemplo de regra: Só aceita se tiver muito patrimônio seguro
        if (patrimonio > 100000 && rendaMensal > 5000) {
            System.out.println("Resultado: Risco Baixo. Recomendação: Renda Fixa e Tesouro.\n");
        } else {
            System.out.println("Resultado: Risco Médio. Recomendação: Poupança apenas.\n");
        }
    }
}

class ModeloModerado implements EstrategiaCalculoRisco {
    @Override
    public void calcularRisco(double patrimonio, double rendaMensal) {
        System.out.println("--- Analisando via Modelo MODERADO ---");
        double capacidadeAporte = rendaMensal * 0.30;
        System.out.println("Capacidade de aporte calculada: R$ " + capacidadeAporte);
        System.out.println("Resultado: Risco Médio. Recomendação: Fundos Multimercado.\n");
    }
}

class ModeloAgressivo implements EstrategiaCalculoRisco {
    @Override
    public void calcularRisco(double patrimonio, double rendaMensal) {
        System.out.println("--- Analisando via Modelo AGRESSIVO ---");
        double alavancagemPermitida = patrimonio * 5;
        System.out.printf("Alavancagem permitida até: R$ %.2f%n", alavancagemPermitida);
        System.out.println("Resultado: Risco Alto. Recomendação: Ações, Cripto e Derivativos.\n");
    }
}

class AnalisadorInvestimento {

    private EstrategiaCalculoRisco estrategiaAtual;

    public AnalisadorInvestimento() {
        this.estrategiaAtual = new ModeloConservador(); 
    }

    public void setEstrategia(EstrategiaCalculoRisco novaEstrategia) {
        this.estrategiaAtual = novaEstrategia;
    }

    public void executarAnalise(double patrimonio, double rendaMensal) {
        if (estrategiaAtual == null) {
            System.out.println("Erro: Nenhuma estratégia definida.");
            return;
        }
        estrategiaAtual.calcularRisco(patrimonio, rendaMensal);
    }
}

public class PlataformaInvestimentos {
    public static void main(String[] args) {
        System.out.println("=== Plataforma de Análise de Investimentos ===\n");

        AnalisadorInvestimento analisador = new AnalisadorInvestimento();

        double patrimonioCliente = 150000.00;
        double rendaCliente = 8000.00;

        analisador.executarAnalise(patrimonioCliente, rendaCliente);

        System.out.println(">> Cliente solicitou mudança de perfil para Moderado...");
        analisador.setEstrategia(new ModeloModerado());
        analisador.executarAnalise(patrimonioCliente, rendaCliente);

        System.out.println(">> Consultor simulando cenário Agressivo...");
        analisador.setEstrategia(new ModeloAgressivo());
        analisador.executarAnalise(patrimonioCliente, rendaCliente);
    }
}
