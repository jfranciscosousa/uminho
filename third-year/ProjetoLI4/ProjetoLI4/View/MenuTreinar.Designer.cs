namespace ProjetoLI4.View
{
    partial class MenuTreinar
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.b_soma = new System.Windows.Forms.Button();
            this.b_subtracao = new System.Windows.Forms.Button();
            this.b_multiplicacao = new System.Windows.Forms.Button();
            this.b_divisao = new System.Windows.Forms.Button();
            this.b_voltar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(103, 14);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(91, 29);
            this.label1.TabIndex = 7;
            this.label1.Text = "Treinar";
            // 
            // b_soma
            // 
            this.b_soma.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_soma.Location = new System.Drawing.Point(22, 85);
            this.b_soma.Name = "b_soma";
            this.b_soma.Size = new System.Drawing.Size(261, 48);
            this.b_soma.TabIndex = 8;
            this.b_soma.Text = "Soma de Frações";
            this.b_soma.UseVisualStyleBackColor = true;
            this.b_soma.Click += new System.EventHandler(this.b_soma_Click);
            // 
            // b_subtracao
            // 
            this.b_subtracao.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_subtracao.Location = new System.Drawing.Point(22, 139);
            this.b_subtracao.Name = "b_subtracao";
            this.b_subtracao.Size = new System.Drawing.Size(261, 48);
            this.b_subtracao.TabIndex = 9;
            this.b_subtracao.Text = "Subtração de Frações";
            this.b_subtracao.UseVisualStyleBackColor = true;
            this.b_subtracao.Click += new System.EventHandler(this.b_subtracao_Click);
            // 
            // b_multiplicacao
            // 
            this.b_multiplicacao.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_multiplicacao.Location = new System.Drawing.Point(22, 193);
            this.b_multiplicacao.Name = "b_multiplicacao";
            this.b_multiplicacao.Size = new System.Drawing.Size(261, 48);
            this.b_multiplicacao.TabIndex = 10;
            this.b_multiplicacao.Text = "Multiplicação de Frações";
            this.b_multiplicacao.UseVisualStyleBackColor = true;
            this.b_multiplicacao.Click += new System.EventHandler(this.b_multiplicacao_Click);
            // 
            // b_divisao
            // 
            this.b_divisao.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_divisao.Location = new System.Drawing.Point(22, 247);
            this.b_divisao.Name = "b_divisao";
            this.b_divisao.Size = new System.Drawing.Size(261, 48);
            this.b_divisao.TabIndex = 11;
            this.b_divisao.Text = "Divisão de Frações";
            this.b_divisao.UseVisualStyleBackColor = true;
            this.b_divisao.Click += new System.EventHandler(this.b_divisao_Click);
            // 
            // b_voltar
            // 
            this.b_voltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_voltar.Location = new System.Drawing.Point(22, 347);
            this.b_voltar.Name = "b_voltar";
            this.b_voltar.Size = new System.Drawing.Size(261, 48);
            this.b_voltar.TabIndex = 12;
            this.b_voltar.Text = "Voltar";
            this.b_voltar.UseVisualStyleBackColor = true;
            this.b_voltar.Click += new System.EventHandler(this.b_voltar_Click);
            // 
            // MenuTreinar
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(305, 406);
            this.Controls.Add(this.b_voltar);
            this.Controls.Add(this.b_divisao);
            this.Controls.Add(this.b_multiplicacao);
            this.Controls.Add(this.b_subtracao);
            this.Controls.Add(this.b_soma);
            this.Controls.Add(this.label1);
            this.Name = "MenuTreinar";
            this.Text = "Assistente de Estudo de Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.MenuTreinar_FormClosed);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button b_soma;
        private System.Windows.Forms.Button b_subtracao;
        private System.Windows.Forms.Button b_multiplicacao;
        private System.Windows.Forms.Button b_divisao;
        private System.Windows.Forms.Button b_voltar;
    }
}