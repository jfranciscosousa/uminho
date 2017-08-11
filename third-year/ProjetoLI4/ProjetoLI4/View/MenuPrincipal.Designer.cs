namespace ProjetoLI4.Logic
{
    partial class MenuPrincipal
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
            this.b_aprender = new System.Windows.Forms.Button();
            this.b_treinar = new System.Windows.Forms.Button();
            this.b_estatisticas = new System.Windows.Forms.Button();
            this.b_sair = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.l_nome = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(179, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(141, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Menu Principal";
            // 
            // b_aprender
            // 
            this.b_aprender.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_aprender.Location = new System.Drawing.Point(32, 95);
            this.b_aprender.Name = "b_aprender";
            this.b_aprender.Size = new System.Drawing.Size(141, 70);
            this.b_aprender.TabIndex = 1;
            this.b_aprender.Text = "Aprender";
            this.b_aprender.UseVisualStyleBackColor = true;
            this.b_aprender.Click += new System.EventHandler(this.b_aprender_Click);
            // 
            // b_treinar
            // 
            this.b_treinar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_treinar.Location = new System.Drawing.Point(179, 95);
            this.b_treinar.Name = "b_treinar";
            this.b_treinar.Size = new System.Drawing.Size(141, 69);
            this.b_treinar.TabIndex = 2;
            this.b_treinar.Text = "Treinar";
            this.b_treinar.UseVisualStyleBackColor = true;
            this.b_treinar.Click += new System.EventHandler(this.b_treinar_Click);
            // 
            // b_estatisticas
            // 
            this.b_estatisticas.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_estatisticas.Location = new System.Drawing.Point(326, 95);
            this.b_estatisticas.Name = "b_estatisticas";
            this.b_estatisticas.Size = new System.Drawing.Size(141, 69);
            this.b_estatisticas.TabIndex = 3;
            this.b_estatisticas.Text = "Estatísticas";
            this.b_estatisticas.UseVisualStyleBackColor = true;
            this.b_estatisticas.Click += new System.EventHandler(this.b_estatisticas_Click);
            // 
            // b_sair
            // 
            this.b_sair.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_sair.Location = new System.Drawing.Point(34, 175);
            this.b_sair.Name = "b_sair";
            this.b_sair.Size = new System.Drawing.Size(432, 66);
            this.b_sair.TabIndex = 4;
            this.b_sair.Text = "Sair";
            this.b_sair.UseVisualStyleBackColor = true;
            this.b_sair.Click += new System.EventHandler(this.b_sair_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(36, 55);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(23, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Olá";
            // 
            // l_nome
            // 
            this.l_nome.AutoSize = true;
            this.l_nome.Location = new System.Drawing.Point(58, 55);
            this.l_nome.Name = "l_nome";
            this.l_nome.Size = new System.Drawing.Size(120, 13);
            this.l_nome.TabIndex = 6;
            this.l_nome.Text = "INSERT_NAME_HERE";
            this.l_nome.Click += new System.EventHandler(this.l_nome_Click);
            // 
            // MenuPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(508, 251);
            this.Controls.Add(this.l_nome);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.b_sair);
            this.Controls.Add(this.b_estatisticas);
            this.Controls.Add(this.b_treinar);
            this.Controls.Add(this.b_aprender);
            this.Controls.Add(this.label1);
            this.Name = "MenuPrincipal";
            this.Text = "Assistente de Estudo de Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.MenuPrincipal_FormClosed);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button b_aprender;
        private System.Windows.Forms.Button b_treinar;
        private System.Windows.Forms.Button b_estatisticas;
        private System.Windows.Forms.Button b_sair;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label l_nome;
    }
}