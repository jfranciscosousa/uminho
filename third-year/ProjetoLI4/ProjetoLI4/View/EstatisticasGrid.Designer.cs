namespace ProjetoLI4.View {
    partial class EstatsticasGrid {
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Data = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Soma = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Certas = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Totais = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.mediaTempoS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Subtração = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CertasSub = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TotaisS = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.MediaTempoSub = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Multiplicação = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CertasM = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TotaisM = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.MediaTempoM = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Divisão = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CertasD = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TotaisD = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.MediaTempoD = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.l_pTotal = new System.Windows.Forms.Label();
            this.l_pSom = new System.Windows.Forms.Label();
            this.l_pSub = new System.Windows.Forms.Label();
            this.l_pMult = new System.Windows.Forms.Label();
            this.l_pDiv = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID,
            this.Data,
            this.Soma,
            this.Certas,
            this.Totais,
            this.mediaTempoS,
            this.Subtração,
            this.CertasSub,
            this.TotaisS,
            this.MediaTempoSub,
            this.Multiplicação,
            this.CertasM,
            this.TotaisM,
            this.MediaTempoM,
            this.Divisão,
            this.CertasD,
            this.TotaisD,
            this.MediaTempoD});
            this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Top;
            this.dataGridView1.Location = new System.Drawing.Point(0, 0);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.Size = new System.Drawing.Size(1197, 413);
            this.dataGridView1.TabIndex = 0;
            this.dataGridView1.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView1_CellContentClick);
            // 
            // ID
            // 
            this.ID.HeaderText = "ID";
            this.ID.Name = "ID";
            this.ID.ReadOnly = true;
            // 
            // Data
            // 
            this.Data.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.AllCells;
            this.Data.HeaderText = "Data";
            this.Data.Name = "Data";
            this.Data.ReadOnly = true;
            this.Data.Width = 55;
            // 
            // Soma
            // 
            this.Soma.HeaderText = "Soma";
            this.Soma.Name = "Soma";
            this.Soma.ReadOnly = true;
            // 
            // Certas
            // 
            this.Certas.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.Certas.HeaderText = "Certas";
            this.Certas.Name = "Certas";
            this.Certas.ReadOnly = true;
            this.Certas.Width = 62;
            // 
            // Totais
            // 
            this.Totais.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.Totais.HeaderText = "Totais";
            this.Totais.Name = "Totais";
            this.Totais.ReadOnly = true;
            this.Totais.Width = 61;
            // 
            // mediaTempoS
            // 
            this.mediaTempoS.HeaderText = "Média Tempo";
            this.mediaTempoS.Name = "mediaTempoS";
            this.mediaTempoS.ReadOnly = true;
            // 
            // Subtração
            // 
            this.Subtração.HeaderText = "Subtração";
            this.Subtração.Name = "Subtração";
            this.Subtração.ReadOnly = true;
            // 
            // CertasSub
            // 
            this.CertasSub.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.CertasSub.HeaderText = "Certas";
            this.CertasSub.Name = "CertasSub";
            this.CertasSub.ReadOnly = true;
            this.CertasSub.Width = 62;
            // 
            // TotaisS
            // 
            this.TotaisS.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.TotaisS.HeaderText = "Totais";
            this.TotaisS.Name = "TotaisS";
            this.TotaisS.ReadOnly = true;
            this.TotaisS.Width = 61;
            // 
            // MediaTempoSub
            // 
            this.MediaTempoSub.HeaderText = "Média Tempo";
            this.MediaTempoSub.Name = "MediaTempoSub";
            this.MediaTempoSub.ReadOnly = true;
            // 
            // Multiplicação
            // 
            this.Multiplicação.HeaderText = "Multiplicação";
            this.Multiplicação.Name = "Multiplicação";
            this.Multiplicação.ReadOnly = true;
            // 
            // CertasM
            // 
            this.CertasM.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.CertasM.HeaderText = "Certas";
            this.CertasM.Name = "CertasM";
            this.CertasM.ReadOnly = true;
            this.CertasM.Width = 62;
            // 
            // TotaisM
            // 
            this.TotaisM.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.TotaisM.HeaderText = "Totais";
            this.TotaisM.Name = "TotaisM";
            this.TotaisM.ReadOnly = true;
            this.TotaisM.Width = 61;
            // 
            // MediaTempoM
            // 
            this.MediaTempoM.HeaderText = "Média Tempo";
            this.MediaTempoM.Name = "MediaTempoM";
            this.MediaTempoM.ReadOnly = true;
            // 
            // Divisão
            // 
            this.Divisão.HeaderText = "Divisão";
            this.Divisão.Name = "Divisão";
            this.Divisão.ReadOnly = true;
            // 
            // CertasD
            // 
            this.CertasD.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.CertasD.HeaderText = "Certas";
            this.CertasD.Name = "CertasD";
            this.CertasD.ReadOnly = true;
            this.CertasD.Width = 62;
            // 
            // TotaisD
            // 
            this.TotaisD.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.TotaisD.HeaderText = "Totais";
            this.TotaisD.Name = "TotaisD";
            this.TotaisD.ReadOnly = true;
            this.TotaisD.Width = 61;
            // 
            // MediaTempoD
            // 
            this.MediaTempoD.HeaderText = "Média Tempo";
            this.MediaTempoD.Name = "MediaTempoD";
            this.MediaTempoD.ReadOnly = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.l_pDiv);
            this.panel1.Controls.Add(this.l_pMult);
            this.panel1.Controls.Add(this.l_pSub);
            this.panel1.Controls.Add(this.l_pSom);
            this.panel1.Controls.Add(this.l_pTotal);
            this.panel1.Controls.Add(this.label5);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel1.Location = new System.Drawing.Point(0, 419);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1197, 95);
            this.panel1.TabIndex = 1;
            this.panel1.Paint += new System.Windows.Forms.PaintEventHandler(this.panel1_Paint);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 10);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(212, 31);
            this.label1.TabIndex = 0;
            this.label1.Text = "Pontuação Total";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(251, 10);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(221, 31);
            this.label2.TabIndex = 1;
            this.label2.Text = "Pontuação Soma";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(499, 10);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(199, 31);
            this.label3.TabIndex = 2;
            this.label3.Text = "Pontuação Sub";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(751, 10);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(202, 31);
            this.label4.TabIndex = 3;
            this.label4.Text = "Pontuação Mult";
            this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(994, 10);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(191, 31);
            this.label5.TabIndex = 4;
            this.label5.Text = "Pontuação Div";
            this.label5.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // l_pTotal
            // 
            this.l_pTotal.AutoSize = true;
            this.l_pTotal.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.l_pTotal.Location = new System.Drawing.Point(72, 53);
            this.l_pTotal.Name = "l_pTotal";
            this.l_pTotal.Size = new System.Drawing.Size(93, 33);
            this.l_pTotal.TabIndex = 5;
            this.l_pTotal.Text = "label6";
            this.l_pTotal.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.l_pTotal.Click += new System.EventHandler(this.label6_Click);
            // 
            // l_pSom
            // 
            this.l_pSom.AutoSize = true;
            this.l_pSom.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.l_pSom.Location = new System.Drawing.Point(311, 53);
            this.l_pSom.Name = "l_pSom";
            this.l_pSom.Size = new System.Drawing.Size(93, 33);
            this.l_pSom.TabIndex = 6;
            this.l_pSom.Text = "label7";
            this.l_pSom.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.l_pSom.Click += new System.EventHandler(this.label7_Click);
            // 
            // l_pSub
            // 
            this.l_pSub.AutoSize = true;
            this.l_pSub.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.l_pSub.Location = new System.Drawing.Point(552, 53);
            this.l_pSub.Name = "l_pSub";
            this.l_pSub.Size = new System.Drawing.Size(93, 33);
            this.l_pSub.TabIndex = 7;
            this.l_pSub.Text = "label8";
            this.l_pSub.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.l_pSub.Click += new System.EventHandler(this.label8_Click);
            // 
            // l_pMult
            // 
            this.l_pMult.AutoSize = true;
            this.l_pMult.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.l_pMult.Location = new System.Drawing.Point(806, 53);
            this.l_pMult.Name = "l_pMult";
            this.l_pMult.Size = new System.Drawing.Size(93, 33);
            this.l_pMult.TabIndex = 8;
            this.l_pMult.Text = "label9";
            this.l_pMult.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // l_pDiv
            // 
            this.l_pDiv.AutoSize = true;
            this.l_pDiv.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.l_pDiv.Location = new System.Drawing.Point(1035, 53);
            this.l_pDiv.Name = "l_pDiv";
            this.l_pDiv.Size = new System.Drawing.Size(109, 33);
            this.l_pDiv.TabIndex = 9;
            this.l_pDiv.Text = "label10";
            this.l_pDiv.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // EstatsticasGrid
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1197, 514);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.dataGridView1);
            this.Name = "EstatsticasGrid";
            this.Text = "Assistente de Estudo Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Estatsticas_FormClosed);
            this.Load += new System.EventHandler(this.EstatsticasGrid_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn Data;
        private System.Windows.Forms.DataGridViewTextBoxColumn Soma;
        private System.Windows.Forms.DataGridViewTextBoxColumn Certas;
        private System.Windows.Forms.DataGridViewTextBoxColumn Totais;
        private System.Windows.Forms.DataGridViewTextBoxColumn mediaTempoS;
        private System.Windows.Forms.DataGridViewTextBoxColumn Subtração;
        private System.Windows.Forms.DataGridViewTextBoxColumn CertasSub;
        private System.Windows.Forms.DataGridViewTextBoxColumn TotaisS;
        private System.Windows.Forms.DataGridViewTextBoxColumn MediaTempoSub;
        private System.Windows.Forms.DataGridViewTextBoxColumn Multiplicação;
        private System.Windows.Forms.DataGridViewTextBoxColumn CertasM;
        private System.Windows.Forms.DataGridViewTextBoxColumn TotaisM;
        private System.Windows.Forms.DataGridViewTextBoxColumn MediaTempoM;
        private System.Windows.Forms.DataGridViewTextBoxColumn Divisão;
        private System.Windows.Forms.DataGridViewTextBoxColumn CertasD;
        private System.Windows.Forms.DataGridViewTextBoxColumn TotaisD;
        private System.Windows.Forms.DataGridViewTextBoxColumn MediaTempoD;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label l_pTotal;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label l_pDiv;
        private System.Windows.Forms.Label l_pMult;
        private System.Windows.Forms.Label l_pSub;
        private System.Windows.Forms.Label l_pSom;

    }
}