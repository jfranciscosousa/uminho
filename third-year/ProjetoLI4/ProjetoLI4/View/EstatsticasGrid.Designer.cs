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
            this.Subtração = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Multiplicação = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Divisão = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
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
            this.Subtração,
            this.Multiplicação,
            this.Divisão});
            this.dataGridView1.Location = new System.Drawing.Point(15, 12);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.Size = new System.Drawing.Size(704, 265);
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
            // Subtração
            // 
            this.Subtração.HeaderText = "Subtração";
            this.Subtração.Name = "Subtração";
            this.Subtração.ReadOnly = true;
            // 
            // Multiplicação
            // 
            this.Multiplicação.HeaderText = "Multiplicação";
            this.Multiplicação.Name = "Multiplicação";
            this.Multiplicação.ReadOnly = true;
            // 
            // Divisão
            // 
            this.Divisão.HeaderText = "Divisão";
            this.Divisão.Name = "Divisão";
            this.Divisão.ReadOnly = true;
            // 
            // Estatsticas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(731, 297);
            this.Controls.Add(this.dataGridView1);
            this.Name = "Estatsticas";
            this.Text = "Estatsticas";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Estatsticas_FormClosed);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn Data;
        private System.Windows.Forms.DataGridViewTextBoxColumn Soma;
        private System.Windows.Forms.DataGridViewTextBoxColumn Subtração;
        private System.Windows.Forms.DataGridViewTextBoxColumn Multiplicação;
        private System.Windows.Forms.DataGridViewTextBoxColumn Divisão;

    }
}