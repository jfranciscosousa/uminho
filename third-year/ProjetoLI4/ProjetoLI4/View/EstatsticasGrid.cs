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
            this.mp = mp;
            sessoes = AlunoDAO.getSessoes(a.id);
            foreach(Sessao s in sessoes){
                this.dataGridView1.Rows.Add(s.id, s.data, s.racioAcerto(1), s.racioAcerto(2), s.racioAcerto(3), s.racioAcerto(4));
            }
        }

        private void Estatsticas_FormClosed(object sender, FormClosedEventArgs e) {            
            mp.Show();
            this.Dispose();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e) {

        }
    }
}
