namespace ProjetoLI4.View
{
    partial class Aprender
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Aprender));
            this.label1 = new System.Windows.Forms.Label();
            this.wmp_video = new AxWMPLib.AxWindowsMediaPlayer();
            this.b_voltar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.wmp_video)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(341, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(113, 29);
            this.label1.TabIndex = 9;
            this.label1.Text = "Aprender";
            // 
            // wmp_video
            // 
            this.wmp_video.Enabled = true;
            this.wmp_video.Location = new System.Drawing.Point(12, 54);
            this.wmp_video.Name = "wmp_video";
            this.wmp_video.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("wmp_video.OcxState")));
            this.wmp_video.Size = new System.Drawing.Size(751, 442);
            this.wmp_video.TabIndex = 10;
            // 
            // b_voltar
            // 
            this.b_voltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.b_voltar.Location = new System.Drawing.Point(12, 502);
            this.b_voltar.Name = "b_voltar";
            this.b_voltar.Size = new System.Drawing.Size(751, 48);
            this.b_voltar.TabIndex = 20;
            this.b_voltar.Text = "Voltar";
            this.b_voltar.UseVisualStyleBackColor = true;
            this.b_voltar.Click += new System.EventHandler(this.b_voltar_Click);
            // 
            // Aprender
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(775, 562);
            this.Controls.Add(this.b_voltar);
            this.Controls.Add(this.wmp_video);
            this.Controls.Add(this.label1);
            this.Name = "Aprender";
            this.Text = "Assistente de Estudo de Frações";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Aprender_FormClosed);
            ((System.ComponentModel.ISupportInitialize)(this.wmp_video)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private AxWMPLib.AxWindowsMediaPlayer wmp_video;
        public System.Windows.Forms.Button b_voltar;
    }
}