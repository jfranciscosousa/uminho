namespace ProjetoLI4 {
    partial class Entrada {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.label1 = new System.Windows.Forms.Label();
            this.b_login = new System.Windows.Forms.Button();
            this.t_nome = new System.Windows.Forms.TextBox();
            this.b_sair = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(191, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Escreve o teu nome:";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // b_login
            // 
            this.b_login.Location = new System.Drawing.Point(17, 86);
            this.b_login.Name = "b_login";
            this.b_login.Size = new System.Drawing.Size(331, 38);
            this.b_login.TabIndex = 1;
            this.b_login.Text = "Entrar";
            this.b_login.UseVisualStyleBackColor = true;
            this.b_login.Click += new System.EventHandler(this.b_login_Click_1);
            // 
            // t_nome
            // 
            this.t_nome.Location = new System.Drawing.Point(209, 36);
            this.t_nome.Name = "t_nome";
            this.t_nome.Size = new System.Drawing.Size(254, 20);
            this.t_nome.TabIndex = 2;
            this.t_nome.TextChanged += new System.EventHandler(this.t_nome_TextChanged);
            this.t_nome.KeyDown += new System.Windows.Forms.KeyEventHandler(this.t_nome_KeyDown);
            // 
            // b_sair
            // 
            this.b_sair.Location = new System.Drawing.Point(376, 86);
            this.b_sair.Name = "b_sair";
            this.b_sair.Size = new System.Drawing.Size(87, 37);
            this.b_sair.TabIndex = 3;
            this.b_sair.Text = "Sair";
            this.b_sair.UseVisualStyleBackColor = true;
            this.b_sair.Click += new System.EventHandler(this.sair_Click);
            // 
            // Entrada
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(496, 156);
            this.Controls.Add(this.b_sair);
            this.Controls.Add(this.t_nome);
            this.Controls.Add(this.b_login);
            this.Controls.Add(this.label1);
            this.Name = "Entrada";
            this.Text = "Assistente de Estudo de Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Entrada_FormClosed);
            this.Load += new System.EventHandler(this.Entrada_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button b_login;
        private System.Windows.Forms.TextBox t_nome;
        private System.Windows.Forms.Button b_sair;
    }
}

