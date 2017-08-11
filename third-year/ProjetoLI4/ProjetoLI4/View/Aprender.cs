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


/*
Tipo:
1- Soma
2- Subtração
3- Multiplicação
4- Divisão
5- O que são
6- Simplificação de Frações
*/

namespace ProjetoLI4.View
{
    public partial class Aprender : Form
    {
        private MenuAprender ma;
        private int tipo;
        public Aprender(MenuAprender ma, int tipo)
        {
            InitializeComponent();

            this.ma = ma;
            if (tipo < 1 || tipo > 6) throw new Exception("Tipo Inválido!");
            this.tipo = tipo;

            //iniciar o video...
            //wmp_video.URL = "D:\\Rafa\\Escola\\GitHub\\ProjetoLI4\\ProjetoLI4\\test_video.mp4";
            wmp_video.URL = "test_video.mp4";

        }


        private void b_voltar_Click(object sender, EventArgs e)
        {
            ma.Show();
            this.Dispose();
        }

        private void Aprender_FormClosed(object sender, FormClosedEventArgs e) {
            ma.Show();
            this.Dispose();
        }
    }
}
