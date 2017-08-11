using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLI4.Logic {
    public class Sessao {
        public int id { get; set; }
        public DateTime data { get; set; }

        private List<Record> records;

        public Sessao(int id, DateTime data) {
            this.id = id;
            this.data = data;
            this.records = new List<Record>();
        }

        public Sessao() {
            this.id = 0;
            this.data = DateTime.Now;
            this.records = new List<Record>();
        }

        public List<Record> getRecords() {
            return this.records;
        }

        public void addRecord(Record r) {
            this.records.Add(r);
        }

        /// <summary>
        /// Procura na sessão o Record que tem o nivel e o tipo dados.
        /// </summary>
        /// <param name="tipo"></param>
        /// <param name="nivel"></param>
        /// <returns>Record respetivo ou null, se não existir.</returns>
        public Record getRecord(int tipo, int nivel) {
            Record r;
            int i;
            for (i = 0; i < records.Count; i++) {
                r = records.ElementAt(i);
                if (r.tipo == tipo && r.nivel == nivel) return r;
            }
            return null;
        }

        /// <summary>
        /// Para um tipo de exercício calcula a percentagem de respostas certas. 
        /// </summary>
        /// <param name="tipo"></param>
        /// <returns>Percentagem de respostas certas. </returns>
        public float racioAcerto(int tipo) {
            int certas = 0, totais = 0;
            foreach (Record r in this.records) {
                if (r.tipo == tipo) {
                    certas += r.nRespCertas;
                    totais += r.nRespTotais;
                }
            }
            if (totais == 0)
                return 0;
            return (certas / (float)totais) * 100;
        }

        public int nRespostasCertas(int tipo)
        {
            int certas = 0;
            foreach (Record r in this.records)
            {
                if (r.tipo == tipo)
                {
                    certas += r.nRespCertas;
                }
                
            }
            return certas;
        }

        public int nRespostasTotais(int tipo)
        {
            int totais = 0;
            foreach (Record r in this.records)
            {
                if (r.tipo == tipo)
                {
                    totais += r.nRespTotais;
                }

            }
            return totais;
        }

        public float mediaTempo(int tipo)
        {
            float totalT = 0, totalR=0;
            foreach (Record r in this.records)
            {
                if (r.tipo == tipo)
                {
                    totalT += r.tempoTotal;
                    totalR += r.nRespTotais;
                }

            }
            if (totalR == 0) return 0;
            
            return totalT/totalR;
        }

        public int diffPontosTotal(int tipo) {
            int total = 0;
            foreach (Record r in this.records) {
                if (r.tipo == tipo) {
                    total += r.diffPontos;
                }
            }
            return total;
        }
    }
}
