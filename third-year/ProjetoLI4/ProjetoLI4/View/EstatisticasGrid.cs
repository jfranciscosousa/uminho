using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ProjetoLI4.Logic;
using ProjetoLI4.DataAccess;

namespace ProjetoLI4.View {
    public partial class EstatsticasGrid : Form {

        private List<Sessao> sessoes;
        private MenuPrincipal mp;
        public EstatsticasGrid(MenuPrincipal mp, Aluno a) {
            InitializeComponent();
            int total, som, sub, mult, div;
            this.mp = mp;
            sessoes = AlunoDAO.getSessoes(a.id);
            foreach (Sessao s in sessoes) {
                this.dataGridView1.Rows.Add(s.id, s.data, s.racioAcerto(1) + "%", s.nRespostasCertas(1), s.nRespostasTotais(1), s.mediaTempo(1), s.racioAcerto(2) + "%", s.nRespostasCertas(2), s.nRespostasTotais(2), s.mediaTempo(2), s.racioAcerto(3) + "%", s.nRespostasCertas(3), s.nRespostasTotais(3), s.mediaTempo(3), s.racioAcerto(4) + "%", s.nRespostasCertas(4), s.nRespostasTotais(4), s.mediaTempo(4));
            }

            som = a.pontosSoma;
            sub = a.pontosSub;
            mult = a.pontosMult;
            div = a.pontosDiv;

            total = som + sub + mult + div;

            this.l_pTotal.Text = String.Format("{0:d}", total);
            this.l_pSom.Text = String.Format("{0:d}", som);
            this.l_pSub.Text = String.Format("{0:d}", sub);
            this.l_pMult.Text = String.Format("{0:d}", mult);
            this.l_pDiv.Text = String.Format("{0:d}", div);

        }

        private void Estatsticas_FormClosed(object sender, FormClosedEventArgs e) {
            mp.Show();
            this.Dispose();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void EstatsticasGrid_Load(object sender, EventArgs e)
        {

        }
    }
}
