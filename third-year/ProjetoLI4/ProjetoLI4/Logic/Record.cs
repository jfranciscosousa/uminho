using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLI4.Logic {
    public class Record {
        public int id { get; set; }
        public String operacao { get; set; }
        public int nivel { get; set; }
        public int nRespTotais { get; set; }
        public int nRespCertas { get; set; }
        public float tempoTotal { get; set; }
        public int diffPontos { get; set; }
        public int tipo { get; set; }

        public Record(int id, String operacao, int nivel, int nRespTotais, int nRespCertas, float tempoTotal, int diffPontos) {
            operacao = operacao.Trim();
            this.id = id;
            this.operacao = operacao;
            this.nivel = nivel;
            this.nRespTotais = nRespTotais;
            this.nRespCertas = nRespCertas;
            this.tempoTotal = tempoTotal;
            this.diffPontos = diffPontos;

            if (operacao != "Soma" && operacao != "Subtração" && operacao != "Multiplicação" && operacao != "Divisão") throw new Exception("Operação inválida! " + operacao);

            if (operacao == "Soma") this.tipo = 1;
            if (operacao == "Subtração") this.tipo = 2;
            if (operacao == "Multiplicação") this.tipo = 3;
            if (operacao == "Divisão") this.tipo = 4;
        }

        public Record(int tipo, int nivel) {
            this.id = 0;
            this.nivel = nivel;
            this.nRespTotais = 0;
            this.nRespCertas = 0;
            this.tempoTotal = 0;
            this.diffPontos = 0;
            this.tipo = tipo;

            if (tipo > 4 || tipo < 1) throw new Exception("Tipo Inválido!");

            if (tipo == 1) this.operacao = "Soma";
            if (tipo == 2) this.operacao = "Subtração";
            if (tipo == 3) this.operacao = "Multiplicação";
            if (tipo == 4) this.operacao = "Divisão";
        }
    }
}
