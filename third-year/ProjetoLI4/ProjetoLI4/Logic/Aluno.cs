using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLI4.Logic {
    public class Aluno {
        public int id { get; set; }
        public String nome { get; set; }
        public int pontosSoma { get; set; }
        public int pontosSub { get; set; }
        public int pontosMult { get; set; }
        public int pontosDiv { get; set; }
        private List<Sessao> sessoes;

        public Aluno(int id, String nome, int soma, int sub, int mult, int div) {
            this.id = id;
            this.nome = nome;
            this.pontosSoma = soma;
            this.pontosSub = sub;
            this.pontosMult = mult;
            this.pontosDiv = div;
            this.sessoes = new List<Sessao>();
        }
        public Aluno(String nome) {
            this.id = 0;
            this.nome = nome;
            this.pontosSoma = 0;
            this.pontosSub = 0;
            this.pontosMult = 0;
            this.pontosDiv = 0;
            this.sessoes = new List<Sessao>();
        }

        public int getNSessoes() {
            return this.sessoes.Count;
        }

        public void addSessao(Sessao s) {
            this.sessoes.Add(s);
        }

        public List<Sessao> getSessoes() {
            return this.sessoes;
        }

        public int diffPontosLast10(int tipo) {
            int length = this.sessoes.Count;
            int diffPontos = 0;
            if (length > 10) length = 10;
            for (int i = 0; i < length; i++) {
                Sessao s = this.sessoes[i];
                diffPontos += s.diffPontosTotal(tipo);
            }
            return diffPontos;
        }

        public int getNivel(int tipo) {
            int pontos = -1;

            if (tipo == 1) pontos = this.pontosSoma;
            if (tipo == 2) pontos = this.pontosSub;
            if (tipo == 3) pontos = this.pontosMult;
            if (tipo == 4) pontos = this.pontosDiv;

            if (pontos == -1) return -1;

            if (pontos >= 0 && pontos < 1000) return 1;
            if (pontos >= 1001 && pontos < 2000) return 2;
            if (pontos >= 2001 && pontos < 3000) return 3;
            if (pontos >= 3001 && pontos < 4000) return 4;
            if (pontos >= 40001) return 5;

            return -1;
        }

        /**
         * Adiciona pontos a um dos tipos de exercicios, e retorna "true" se o nivel aumentou
         * */
        public bool addPoints(int tipo, int pontos) {
            int antigo = 0, novo = 0;
            if (tipo > 4 || tipo < 1) throw new Exception("Tipo Inválido!");

            if (tipo == 1) {
                antigo = getNivel(tipo);
                this.pontosSoma += pontos;
                novo = getNivel(tipo);
            }
            if (tipo == 2) {
                antigo = getNivel(tipo);
                this.pontosSub += pontos;
                novo = getNivel(tipo);
            }
            if (tipo == 3) {
                antigo = getNivel(tipo);
                this.pontosMult += pontos;
                novo = getNivel(tipo);
            }
            if (tipo == 4) {
                antigo = getNivel(tipo);
                this.pontosDiv += pontos;
                novo = getNivel(tipo);
            }

            if (antigo != novo) return true;
            else return false;


        }

        /**
         * Remove pontos a um dos tipos de exercicios, e retorna "true" se o nivel desceu
         * */
        public bool removePoints(int tipo, int pontos) {
            int antigo = 0, novo = 0;
            if (tipo > 4 || tipo < 1) throw new Exception("Tipo Inválido!");

            if (tipo == 1) {
                antigo = getNivel(tipo);
                this.pontosSoma -= pontos;
                if (this.pontosSoma < 0) this.pontosSoma = 0;
                novo = getNivel(tipo);
            }
            if (tipo == 2) {
                antigo = getNivel(tipo);
                this.pontosSub -= pontos;
                if (this.pontosSub < 0) this.pontosSub = 0;
                novo = getNivel(tipo);
            }
            if (tipo == 3) {
                antigo = getNivel(tipo);
                this.pontosMult -= pontos;
                if (this.pontosMult < 0) this.pontosMult = 0;
                novo = getNivel(tipo);
            }
            if (tipo == 4) {
                antigo = getNivel(tipo);
                this.pontosDiv -= pontos;
                if (this.pontosDiv < 0) this.pontosDiv = 0;
                novo = getNivel(tipo);
            }

            if (antigo != novo) return true;
            else return false;
        }
    }
}
