using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ProjetoLI4.DataAccess;
using ProjetoLI4.Logic;

namespace ProjetoLI4 {
    public partial class Entrada : Form {
        public Entrada() {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void t_nome_TextChanged(object sender, EventArgs e)
        {

        }

        private void b_login_Click_1(object sender, EventArgs e) {
            String user = this.t_nome.Text;
            Aluno aluno;
            if (AlunoDAO.alunoExiste(user)) {
                aluno = AlunoDAO.getAluno(user);
            }
            else {
                aluno = new Aluno(user);
                aluno.id=AlunoDAO.putAluno(aluno);
            }   
            this.Hide();
            ProjetoLI4.Logic.MenuPrincipal mMenu = new ProjetoLI4.Logic.MenuPrincipal(this, aluno);
            mMenu.Show();
        }

        private void Entrada_Load(object sender, EventArgs e) {

        }

        private void t_nome_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Return)
            {
                b_login.PerformClick();
            }
        }

        private void sair_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void Entrada_FormClosed(object sender, FormClosedEventArgs e) {
            this.Dispose();
        }
    }
}
