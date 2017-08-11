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
using ProjetoLI4.View;

namespace ProjetoLI4.Logic
{
    public partial class MenuPrincipal : Form
    {
        Entrada ent;
        Aluno aluno;
        Sessao sessao;
        public MenuPrincipal(Entrada e, Aluno a)
        {
            this.ent = e;
            this.aluno = a;
            this.sessao = new Sessao();
            this.aluno.addSessao(sessao); 

            InitializeComponent();
            l_nome.Text = a.nome;
        }

        private void b_sair_Click(object sender, EventArgs e)
        {
            ent.Show();
            this.Dispose();
        }

        private void l_nome_Click(object sender, EventArgs e)
        {

        }

        private void b_aprender_Click(object sender, EventArgs e)
        {
            MenuAprender mAprender = new MenuAprender(aluno, sessao, this);
            this.Hide();
            mAprender.Show();
        }

        private void b_treinar_Click(object sender, EventArgs e)
        {
            MenuTreinar mAprender = new MenuTreinar(aluno, sessao, this);
            this.Hide();
            mAprender.Show();
        }

        private void b_estatisticas_Click(object sender, EventArgs e)
        {
            
            Estatistica est = new Estatistica(this);
            this.Hide();
            est.Show();
        }

        private void MenuPrincipal_FormClosed(object sender, FormClosedEventArgs e) {
            
            ent.Show();
            this.Dispose();
        }

    }
}
