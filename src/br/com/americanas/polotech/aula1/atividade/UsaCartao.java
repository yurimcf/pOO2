package br.com.americanas.polotech.aula1.atividade;

import br.com.americanas.polotech.aula1.atividade.UsaCartao.OpçaoDePagamento;/*
Você quer vender um notebook e está aceitando pagamento no cartão,
porém existem algumas taxas da maquininha e
você quer saber quanto você irá receber vendendo seu notebook no débito,
no crédito à vista ou no crédito parcelado.
Para isso, crie uma interface:
• O nome da interface deverá ser TaxaMaquininha;
• Deverá ter um único método chamado getValorTaxa(), que não recebe nada e devolve um double.
As taxas são a partir de 0,95% no débito; 0,99% no crédito à vista e de 9,99% no parcelado.

Na classe Main deverá imprimir:
• "Valor cobrado pela venda do Notebook no 'opcaoDePagamentoAqui'
foi 'valorX' e você irá receber 'valorY'"
 */

public class UsaCartao {
    public static void main(String[] args) {
        Double valorCobrado = 3000.0;
        OpçaoDePagamento opçaoDePagamento = OpçaoDePagamento.PAGAMENTO_DEBITO;
        Double valorComATaxa = null;
        Double valorDesconto = null;

        TaxaMaquininha taxa;
        String tipoDePagamento = "";

        switch (opçaoDePagamento) {
            case PAGAMENTO_DEBITO:
                taxa = new TaxaMaquininhaDebitoImp();
                valorComATaxa = valorCobrado  * (1 - taxa.getValorTaxa()/100);
                valorDesconto = valorCobrado * (taxa.getValorTaxa()/100);

                tipoDePagamento = OpçaoDePagamento.PAGAMENTO_DEBITO.toString();
                break;
            case PAGAMENTO_A_VISTA:
                taxa = new TaxaMaquininhaAVistaImp();
                valorComATaxa = valorCobrado  * (1 - taxa.getValorTaxa()/100);
                valorDesconto = valorCobrado * (taxa.getValorTaxa()/100);

                tipoDePagamento = OpçaoDePagamento.PAGAMENTO_A_VISTA.toString();
                break;
            case PAGAMENTO_PARCELADO:
                taxa = new TaxaMaquininhaParceladoImp();
                valorComATaxa = valorCobrado  * (1 - taxa.getValorTaxa()/100);
                valorDesconto = valorCobrado * (taxa.getValorTaxa()/100);

                tipoDePagamento = OpçaoDePagamento.PAGAMENTO_PARCELADO.toString();
                break;
        }

        System.out.printf("Valor cobrado pela venda do Notebook no ' %s '"  + " foi ' %.2f ' e você irá receber ' %.2f '",
                tipoDePagamento,valorDesconto,valorComATaxa);
    }

    enum OpçaoDePagamento {
        PAGAMENTO_DEBITO("Débito"), PAGAMENTO_A_VISTA("Cartão de Crédito a VISTA"),
        PAGAMENTO_PARCELADO("Cartão de Crédito PARCELADO");

        private String opcao;

        OpçaoDePagamento(String opcao) {
            this.opcao = opcao;
        }

        @Override
        public String toString() {
            return this.opcao;
        }
    }
}
