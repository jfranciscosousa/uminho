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
    public partial class MenuTreinar : Form {
        private Aluno aluno;
        private Sessao sessao;
        private MenuPrincipal menuA;
        public MenuTreinar(Aluno a, Sessao s, MenuPrincipal m) {
            this.aluno = a;
            this.sessao = s;
            this.menuA = m;
            InitializeComponent();
        }
        public MenuTreinar() {
            InitializeComponent();
        }

        private void b_soma_Click(object sender, EventArgs e) {
            Treinar menuT = new Treinar(this, 1, aluno, sessao);
            menuT.Show();
            this.Hide();
        }

        private void b_subtracao_Click(object sender, EventArgs e) {
            Treinar menuT = new Treinar(this, 2, aluno, sessao);
            menuT.Show();
            this.Hide();
        }

        private void b_multiplicacao_Click(object sender, EventArgs e) {
            Treinar menuT = new Treinar(this, 3, aluno, sessao);
            menuT.Show();
            this.Hide();
        }

        private void b_divisao_Click(object sender, EventArgs e) {
            Treinar menuT = new Treinar(this, 4, aluno, sessao);
            menuT.Show();
            this.Hide();
        }

        private void b_voltar_Click(object sender, EventArgs e) {
            menuA.Show();
            this.Close();
        }

        private void MenuTreinar_FormClosed(object sender, FormClosedEventArgs e) {
            if (sessao.getRecords().Count > 0)
            {
                AlunoDAO.putSessao(sessao, aluno.id);
                AlunoDAO.replaceAluno(this.aluno);
            }
            menuA.Show();
            this.Dispose();
        }
    }
}
