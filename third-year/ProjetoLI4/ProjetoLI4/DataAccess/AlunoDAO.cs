using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProjetoLI4.Logic;
using System.Data.SqlClient;
using System.Windows.Forms;
using System.IO;
using System.Globalization;

namespace ProjetoLI4.DataAccess {
    class AlunoDAO {

        private static String dataconn = "Data Source=(LocalDB)\\v11.0;AttachDbFilename="+Path.GetDirectoryName(Application.ExecutablePath)+"\\Database.mdf;Integrated Security=True";
        private static int getNrAlunos() {
            string stmt = "SELECT COUNT(*) FROM ALUNO";
            int count = 0;

            using (SqlConnection thisConnection = new SqlConnection(dataconn)) {
                using (SqlCommand cmdCount = new SqlCommand(stmt, thisConnection)) {
                    thisConnection.Open();
                    count = (int)cmdCount.ExecuteScalar();
                }
            }
            return count;
        }

        private static int getNrSessoes() {
            string stmt = "SELECT COUNT(*) FROM SESSAO";
            int count = 0;

            using (SqlConnection thisConnection = new SqlConnection(dataconn)) {
                using (SqlCommand cmdCount = new SqlCommand(stmt, thisConnection)) {
                    thisConnection.Open();
                    count = (int)cmdCount.ExecuteScalar();
                }
            }
            return count;
        }

        public static void replaceAluno(Aluno a) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    string query = "UPDATE ALUNO SET";
                    query += " pontosSoma=" + a.pontosSoma + " ,pontosSub=" + a.pontosSub + ",pontosMult=" + a.pontosMult + ",pontosDiv=" + a.pontosDiv;
                    query += "WHERE nome=\'" + a.nome + "\'";
                    using (SqlCommand command = new SqlCommand(query, connection)) {
                        command.CommandText = query;
                        command.ExecuteNonQuery();
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private static void putRecord(Record r, int sessao) {
            string alunoquery = "";
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    NumberFormatInfo nfi = new NumberFormatInfo();
                    nfi.NumberDecimalSeparator = ".";
                    using (SqlCommand command = connection.CreateCommand()) {
                        alunoquery = "INSERT RECORD (sessao,operacao,nivel,nRespTotais,nRespCertas,mediaTempo,difPontos) OUTPUT INSERTED.ID";
                        alunoquery += " VALUES (" + sessao + ",'" + r.operacao + "'," + r.nivel + "," + r.nRespTotais + "," + r.nRespCertas + "," + r.tempoTotal.ToString(nfi) + "," + r.diffPontos + ")";
                        command.CommandText = alunoquery;
                        command.ExecuteNonQuery();
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message + "\n" + alunoquery, "Erro SQL!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        public static void putSessao(Sessao s, int aluno) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    using (SqlCommand command = connection.CreateCommand()) {
                        string alunoquery = "INSERT SESSAO (data,aluno) OUTPUT INSERTED.ID";
                        alunoquery += " VALUES ('" + s.data.ToString("s") + "'," + aluno + ")";
                        command.CommandText = alunoquery;
                        int id = (int)command.ExecuteScalar();
                        foreach (Record r in s.getRecords()) {
                            putRecord(r, id);
                        }
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        public static int putAluno(Aluno a) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    if (AlunoDAO.alunoExiste(a.nome)) {
                        return 0;
                    }
                    else {
                        connection.Open();
                        string alunoquery = "INSERT ALUNO (nome,pontosSoma,pontosSub,pontosMult,pontosDiv) OUTPUT INSERTED.ID ";
                        alunoquery += "VALUES (\'" + a.nome + "\'," + a.pontosSoma + "," + a.pontosSub + "," + a.pontosMult + "," + a.pontosDiv + ")";
                        using (SqlCommand command = connection.CreateCommand()) {
                            command.CommandText = alunoquery;
                            return (int)command.ExecuteScalar();
                        }
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return 0;
                }
            }
        }

        private static void getRecords(Sessao sessao) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    using (SqlCommand command = new SqlCommand(
                    "SELECT * FROM Record where sessao=" + sessao.id + "", connection)) {
                        using (SqlDataReader reader = command.ExecuteReader()) {
                            while (reader.Read()) {
                                int id = reader.GetInt32(0);
                                string op = reader.GetString(2);
                                int nivel = reader.GetInt32(3);
                                int nRespTotais = reader.GetInt32(4);
                                int nRespCertas = reader.GetInt32(5);
                                float mediaTempo = (float)reader.GetDecimal(6);
                                int diffPontos = reader.GetInt32(7);
                                sessao.addRecord(new Record(id, op, nivel, nRespTotais, nRespCertas, mediaTempo, diffPontos));
                            }
                        }
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL! getrecord", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        public static List<Sessao> getSessoes(int aluno) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    using (SqlCommand command = new SqlCommand(
                    "SELECT * FROM Sessao where aluno='" + aluno + "'", connection)) {
                        using (SqlDataReader reader = command.ExecuteReader()) {
                            List<Sessao> sessoes = new List<Sessao>();
                            while (reader.Read()) {
                                int idsessao = reader.GetInt32(0);
                                DateTime data = reader.GetDateTime(1);
                                Sessao s = new Sessao(idsessao, data);
                                AlunoDAO.getRecords(s);
                                sessoes.Add(s);
                            }
                            return sessoes.OrderByDescending(s => s.data).ToList();
                        }
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL! getsessoes", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return null;
                }
            }
        }

        public static Aluno getAluno(String nome) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                try {
                    connection.Open();
                    using (SqlCommand command = new SqlCommand(
                    "SELECT * FROM Aluno where nome='" + nome + "'", connection)) {
                        using (SqlDataReader reader = command.ExecuteReader()) {
                            reader.Read();
                            if (reader.HasRows) {
                                Aluno a = new Aluno(reader.GetInt32(0), reader.GetString(1),
                                    reader.GetInt32(2), reader.GetInt32(3), reader.GetInt32(5), reader.GetInt32(4));
                                return a;
                            }
                            else
                                return null;
                        }
                    }
                }
                catch (SqlException ex) {
                    MessageBox.Show(ex.Message, "Erro SQL!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    return null;
                }
            }
        }

        public static bool alunoExiste(String nome) {
            using (SqlConnection connection = new SqlConnection(dataconn)) {
                connection.Open();
                using (SqlCommand command = new SqlCommand(
                "SELECT * FROM Aluno where nome='" + nome + "'", connection)) {
                    using (SqlDataReader reader = command.ExecuteReader()) {
                        reader.Read();
                        if (reader.HasRows)
                            return true;
                        else
                            return false;
                    }
                }
            }
        }
    }
}
