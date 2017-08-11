namespace ProjetoLI4.View
{
    partial class Estatistica
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
            this.t_nome = new System.Windows.Forms.TextBox();
            this.b_mostrar = new System.Windows.Forms.Button();
            this.b_voltar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(24, 27);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(70, 25);
            this.label1.TabIndex = 1;
            this.label1.Text = "Nome:";
            // 
            // t_nome
            // 
            this.t_nome.Location = new System.Drawing.Point(100, 29);
            this.t_nome.Name = "t_nome";
            this.t_nome.Size = new System.Drawing.Size(445, 20);
            this.t_nome.TabIndex = 2;
            // 
            // b_mostrar
            // 
            this.b_mostrar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.b_mostrar.Location = new System.Drawing.Point(301, 76);
            this.b_mostrar.Name = "b_mostrar";
            this.b_mostrar.Size = new System.Drawing.Size(244, 48);
            this.b_mostrar.TabIndex = 7;
            this.b_mostrar.Text = "Mostrar Estatísticas";
            this.b_mostrar.UseVisualStyleBackColor = true;
            this.b_mostrar.Click += new System.EventHandler(this.b_mostrar_Click);
            // 
            // b_voltar
            // 
            this.b_voltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_voltar.Location = new System.Drawing.Point(12, 76);
            this.b_voltar.Name = "b_voltar";
            this.b_voltar.Size = new System.Drawing.Size(214, 48);
            this.b_voltar.TabIndex = 13;
            this.b_voltar.Text = "Voltar";
            this.b_voltar.UseVisualStyleBackColor = true;
            this.b_voltar.Click += new System.EventHandler(this.b_voltar_Click);
            // 
            // Estatistica
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(557, 136);
            this.Controls.Add(this.b_voltar);
            this.Controls.Add(this.b_mostrar);
            this.Controls.Add(this.t_nome);
            this.Controls.Add(this.label1);
            this.Name = "Estatistica";
            this.Text = "Assistende de Estudo de Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Estatistica_FormClosed);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox t_nome;
        private System.Windows.Forms.Button b_mostrar;
        private System.Windows.Forms.Button b_voltar;
    }
}