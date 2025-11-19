import java.util.ArrayList;
import java.util.List;

interface Relatorio {
    void prepararDados();
    void gerar();
}

class RelatorioDiario implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("[Diário] Coletando dados das últimas 24 horas...");
        System.out.println("[Diário] Aplicando prioridade: Alta rotatividade.");
    }

    @Override
    public void gerar() {
        System.out.println("[Diário] Gerando PDF com resumo operacional do dia.\n");
    }
}

class RelatorioSemanal implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("[Semanal] Consolidando dados dos últimos 7 dias...");
        System.out.println("[Semanal] Calculando KPIs e tendências de estoque.");
    }

    @Override
    public void gerar() {
        System.out.println("[Semanal] Gerando planilha Excel com gráficos de desempenho.\n");
    }
}

class RelatorioEmergencial implements Relatorio {
    @Override
    public void prepararDados() {
        System.out.println("[EMERGÊNCIA] Acessando dados em tempo real!");
        System.out.println("[EMERGÊNCIA] Ignorando formatação visual, priorizando velocidade.");
    }

    @Override
    public void gerar() {
        System.out.println("[EMERGÊNCIA] Enviando alerta de texto simples para gerência.\n");
    }
}

interface RelatorioFactory {
    Relatorio criarRelatorio();
}


class RelatorioDiarioFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioDiario();
    }
}

class RelatorioSemanalFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioSemanal();
    }
}

class RelatorioEmergencialFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio() {
        return new RelatorioEmergencial();
    }
}

public class SistemaLogistica {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Relatórios Logísticos ===\n");


        List<RelatorioFactory> filaDeRelatorios = new ArrayList<>();

        filaDeRelatorios.add(new RelatorioDiarioFactory());
        filaDeRelatorios.add(new RelatorioSemanalFactory());
        filaDeRelatorios.add(new RelatorioEmergencialFactory());

        for (RelatorioFactory fabrica : filaDeRelatorios) {
            Relatorio relatorio = fabrica.criarRelatorio();
            
            relatorio.prepararDados();
            relatorio.gerar();
        }
    }
}
