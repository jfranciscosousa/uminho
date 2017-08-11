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
using ProjetoLI4.View;

namespace ProjetoLI4.Logic {
    public partial class MenuAprender : Form {
        private Aluno aluno;
        private Sessao sessao;
        private MenuPrincipal menuA;
        public MenuAprender(Aluno a, Sessao s, MenuPrincipal m) {
            this.aluno = a;
            this.sessao = s;
            this.menuA = m;
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e) { //não altera o nome, Fica sempre button1...
            Aprender a = new Aprender(this, 6);
            a.Show();
            this.Hide();
        }

        private void b_OQueSao_Click(object sender, EventArgs e) {
            Aprender a = new Aprender(this, 5);
            a.Show();
            this.Hide();
        }

        private void b_voltar_Click(object sender, EventArgs e)
        {
            menuA.Show();
            this.Dispose();
        }

        private void b_subtracao_Click(object sender, EventArgs e)
        {
            Aprender a = new Aprender(this, 2);
            a.Show();
            this.Hide();
        }

        private void b_soma_Click(object sender, EventArgs e)
        {
            Aprender a = new Aprender(this, 1);
            a.Show();
            this.Hide();
        }

        private void b_multiplicacao_Click(object sender, EventArgs e)
        {
            Aprender a = new Aprender(this, 3);
            a.Show();
            this.Hide();
        }

        private void b_divisao_Click(object sender, EventArgs e)
        {
            Aprender a = new Aprender(this, 4);
            a.Show();
            this.Hide();
        }

        private void MenuAprender_FormClosed(object sender, FormClosedEventArgs e) {
            menuA.Show();
            this.Dispose();
        }
    }
}
