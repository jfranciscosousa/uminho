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
    public partial class Estatistica : Form {
        private MenuPrincipal mp;
        public Estatistica(MenuPrincipal mp) {
            this.mp = mp;
            InitializeComponent();
        }

        private void b_voltar_Click(object sender, EventArgs e) {
            mp.Show();
            this.Dispose();
        }

        private void b_mostrar_Click(object sender, EventArgs e) {
            Aluno a = AlunoDAO.getAluno(this.t_nome.Text);
            if (a == null)
                MessageBox.Show("Este aluno não está registado no programa!", "Erro!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else {
                EstatsticasGrid estgrid = new EstatsticasGrid(mp, a);
                this.Dispose();
                estgrid.Show();
            }
        }

        private void Estatistica_FormClosed(object sender, FormClosedEventArgs e) {
            mp.Show();
            this.Dispose();
        }
    }
}
