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

/*
Tipo:
1- Soma
2- Subtração
3- Multiplicação
4- Divisão
*/

namespace ProjetoLI4.View
{
    public partial class Treinar : Form
    {
        private Aluno aluno;
        private Sessao sessao;
        private MenuTreinar menuTreinar;
        private int tipo;
        private DateTime start;
        private DateTime end;

        public Treinar(MenuTreinar mt, int tipo, Aluno a, Sessao s)
        {
            InitializeComponent();

            this.aluno = a;
            this.sessao = s;
            this.menuTreinar = mt;
            this.tipo = tipo;

            if (sessao.getRecord(tipo, aluno.getNivel(tipo)) == null)
            {
                Record r = new Record(tipo, aluno.getNivel(tipo));
                sessao.addRecord(r);
            }

            useOperator();
            generateExercicio();

        }

        private void l_numerador1_Click(object sender, EventArgs e)
        {

        }

        private void Treinar_Load(object sender, EventArgs e)
        {

        }

        private void b_voltar_Click(object sender, EventArgs e)
        {
            menuTreinar.Show();
            this.Close();
        }

        private void b_proximo_Click(object sender, EventArgs e)
        {
            //faz load ao proximo exercício...
            generateExercicio();
            s_denominador.Value = 1;
            s_numerador.Value = 1;

            b_proximo.Enabled = false;
            b_confirmar.Enabled = true;
        }

        private void b_confirmar_Click(object sender, EventArgs e)
        {
            float n1, n2, n3, d1, d2, d3;
            float res = 0, res2;
            bool trocouNivel;
            Record r = sessao.getRecord(tipo, aluno.getNivel(tipo));

            n1 = Convert.ToInt32(l_numerador1.Text);
            n2 = Convert.ToInt32(l_numerador2.Text);
            d1 = Convert.ToInt32(l_denominador1.Text);
            d2 = Convert.ToInt32(l_denominador2.Text);

            n3 = (int)s_numerador.Value;
            d3 = (int)s_denominador.Value;

            if (tipo == 1) res = (n1 / d1) + (n2 / d2);
            if (tipo == 2) res = (n1 / d1) - (n2 / d2);
            if (tipo == 3) res = (n1 / d1) * (n2 / d2);
            if (tipo == 4) res = (n1 / d1) / (n2 / d2);

            res2 = n3 / d3;

            this.end = DateTime.Now;
            r.tempoTotal += ((float)(this.end - this.start).TotalSeconds);

            if (res == res2)
            {//acertou
                this.b_proximo.Enabled = true;
                MessageBox.Show("Acertou!\n+100 pontos!", "Treinar", MessageBoxButtons.OK, MessageBoxIcon.Information);
                trocouNivel = aluno.addPoints(tipo, 100);//adiciona 100 pontos
                r.nRespCertas++;
                r.diffPontos += 5;
                if (trocouNivel) MessageBox.Show("Subiu de nível, parabéns!!", "Treinar", MessageBoxButtons.OK, MessageBoxIcon.Information);
                b_confirmar.Enabled = false;
            }
            else
            {//falhou
                MessageBox.Show("Errou!\n-150 pontos", "Treinar", MessageBoxButtons.OK, MessageBoxIcon.Information);
                trocouNivel = aluno.removePoints(tipo, 150); //remove 150 pontos
                r.diffPontos -= 7;
                if (trocouNivel) MessageBox.Show("Desceu de nível, veja a aula respetiva!", "Treinar", MessageBoxButtons.OK, MessageBoxIcon.Information);
                
            }
            r.nRespTotais++;

            if (trocouNivel)
            {
                r = sessao.getRecord(tipo, aluno.getNivel(tipo));
                if (r == null)
                {
                    r = new Record(tipo, aluno.getNivel(tipo));
                    sessao.addRecord(r);
                }
            }

        }

        private void generateExercicio() //falta acabar!!!!!
        {
            int nivel = aluno.getNivel(tipo);
            if (nivel == -1)
            {
                MessageBox.Show("Nivel recebido inválido!", "ERRO", MessageBoxButtons.OKCancel, MessageBoxIcon.Error);
                System.Windows.Forms.Application.Exit(); //sair do programa
            }

            NumberGenerator ng = new NumberGenerator();

            if (nivel == 1)
            {
                l_numerador1.Text = "" + ng.randomInt(1, 10);
                l_numerador2.Text = "" + ng.randomInt(1, 10);
                l_denominador1.Text = "" + ng.randomInt(1, 10);
                l_denominador2.Text = l_denominador1.Text;
            }
            if (nivel == 2)
            {
                l_numerador1.Text = "" + ng.randomInt(10, 30);
                l_numerador2.Text = "" + ng.randomInt(10, 30);
                l_denominador1.Text = "" + ng.randomInt(10, 30);
                l_denominador2.Text = l_denominador1.Text;
            }
            if (nivel == 3)
            {
                l_numerador1.Text = "" + ng.randomInt(30, 100);
                l_numerador2.Text = "" + ng.randomInt(30, 100);
                l_denominador1.Text = "" + ng.randomInt(30, 100);
                l_denominador2.Text = "" + ng.randomInt(30, 100);
            }
            if (nivel == 4)
            {
                l_numerador1.Text = "" + ng.randomPrime(30);
                l_numerador2.Text = "" + ng.randomPrime(30);
                l_denominador1.Text = "" + ng.randomPrime(30);
                l_denominador2.Text = "" + ng.randomPrime(30);
            }
            if (nivel == 5)
            {
                l_numerador1.Text = "" + ng.randomPrime();
                l_numerador2.Text = "" + ng.randomPrime();
                l_denominador1.Text = "" + ng.randomPrime();
                l_denominador2.Text = "" + ng.randomPrime();
            }
            if (tipo == 2)
            {
                while (Convert.ToInt32(l_numerador1.Text) < Convert.ToInt32(l_numerador2.Text))
                {
                    if (nivel == 1)
                    {
                        l_numerador1.Text = "" + ng.randomInt(1, 10);
                        l_numerador2.Text = "" + ng.randomInt(1, 10);
                        l_denominador1.Text = "" + ng.randomInt(1, 10);
                        l_denominador2.Text = l_denominador1.Text;
                    }
                    if (nivel == 2)
                    {
                        l_numerador1.Text = "" + ng.randomInt(10, 30);
                        l_numerador2.Text = "" + ng.randomInt(10, 30);
                        l_denominador1.Text = "" + ng.randomInt(10, 30);
                        l_denominador2.Text = l_denominador1.Text;
                    }
                    if (nivel == 3)
                    {
                        l_numerador1.Text = "" + ng.randomInt(30, 100);
                        l_numerador2.Text = "" + ng.randomInt(30, 100);
                        l_denominador1.Text = "" + ng.randomInt(30, 100);
                        l_denominador2.Text = "" + ng.randomInt(30, 100);
                    }
                    if (nivel == 4)
                    {
                        l_numerador1.Text = "" + ng.randomPrime(30);
                        l_numerador2.Text = "" + ng.randomPrime(30);
                        l_denominador1.Text = "" + ng.randomPrime(30);
                        l_denominador2.Text = "" + ng.randomPrime(30);
                    }
                    if (nivel == 5)
                    {
                        l_numerador1.Text = "" + ng.randomPrime();
                        l_numerador2.Text = "" + ng.randomPrime();
                        l_denominador1.Text = "" + ng.randomPrime();
                        l_denominador2.Text = "" + ng.randomPrime();
                    }
                }
            }

            this.start = DateTime.Now;
        }

        private void useOperator()
        {
            if (tipo == 1) l_operador.Text = "+";
            if (tipo == 2) l_operador.Text = "-";
            if (tipo == 3) l_operador.Text = "X";
            if (tipo == 4) l_operador.Text = "÷";
        }

        private void Treinar_FormClosed(object sender, FormClosedEventArgs e)
        {
            
            menuTreinar.Show();
            this.Dispose();
        }
    }
}
