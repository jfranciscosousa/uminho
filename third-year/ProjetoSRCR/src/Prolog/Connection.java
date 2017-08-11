/*
 * Copyright 2015 josesousa9000@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Prolog;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import se.sics.jasper.Query;
import se.sics.jasper.SICStus;
import se.sics.jasper.SPException;
import se.sics.jasper.Term;

/**
 * Classe que contém um conjunto de métodos para comunicar com o Prolog, no
 * contexto deste problema de comércio de automóveis.
 *
 * @author josesousa9000@gmail.com
 */
public class Connection {

    private final SICStus sicstus;

    /**
     * Construtor vazio. Inicializa a conexão ao SICStus Prolog.
     *
     * @throws SPException
     */
    public Connection() throws SPException {
        this.sicstus = new SICStus("");
    }

    /**
     * Consulta um ficheiro Prolog.
     *
     * @param file Nome do ficheiro a consultar.
     * @throws SPException Caso o Jasper encontre um problema.
     */
    public void load(String file) throws SPException {
        this.sicstus.load(file);
    }

    /**
     * Adiciona um automóvel 'a', utilizando o predicado 'adicionar'.
     *
     * @param a Automóvel a adicionar.
     * @return Verdadeiro se adicionar com sucesso, falso caso contrário
     * @throws SPException Caso o Jasper encontre um problema.
     */
    public boolean addAutomovel(Automovel a) throws SPException {
        String query = "adicionar(automovel(A,B,C,D,E,F,G)).";
        Map map = new HashMap();
        map.put("A", sicstus.newTerm(a.getMatricula()));
        map.put("B", sicstus.newTerm(a.getMarca()));
        map.put("C", sicstus.newTerm(a.getModelo()));
        map.put("D", sicstus.newTerm(a.getCor()));
        map.put("E", sicstus.newTerm(a.getEstado()));
        map.put("F", sicstus.newTerm(a.getAno()));
        map.put("G", sicstus.newTerm(a.getDono()));
        return sicstus.query(query, map);
    }

    /**
     * Adiciona um automovel 'a', substituindo qualquer automóvel com a
     * matrícula do automóvel 'a'. Utiliza o predicado
     * substituir(autvelho,autnovo).
     *
     * @param a Automóvel com os dados alterados.
     * @return Verdadeiro se adicionar com sucesso, falso caso contrário.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public boolean alterarAutomovel(Automovel a) throws SPException, InterruptedException, Exception {
        Automovel old = this.getAutomovel(a.getMatricula());
        if (old == null) {
            return false;
        }
        String oldA = String.format("automovel('%s','%s','%s','%s',%d,%d,'%s')",
                old.getMatricula(),
                old.getMarca(),
                old.getModelo(),
                old.getCor(),
                old.getEstado(),
                old.getAno(),
                old.getDono());
        String aA = String.format("automovel('%s','%s','%s','%s',%d,%d,'%s')",
                a.getMatricula(),
                a.getMarca(),
                a.getModelo(),
                a.getCor(),
                a.getEstado(),
                a.getAno(),
                a.getDono());
        String query = String.format("substituir(%s,%s).", oldA, aA);
        Map<String, Term> map = new HashMap<>();
        String aux = "X";
        map.put("X", this.sicstus.readFromString(query));
        return this.sicstus.query(query, map);
    }

    /**
     * Remove um automóvel com uma dada matricula.
     *
     * @param matricula Matricula do automóvel a remover.
     * @return Verdadeiro se remover com sucesso, falso caso contrário.
     * @throws SPException Caso o Jasper encontre um problema.
     */
    public boolean removeAutomovel(String matricula) throws SPException {
        String query = "retract(automovel(A,B,C,D,E,F,G)).";
        Map map = new HashMap();
        map.put("A", sicstus.newTerm(matricula));
        return sicstus.query(query, map);
    }

    /**
     * Obtém um objeto do tipo Automovel a partir de uma matricula. Utiliza o
     * predicado demo([automovel(matricula,B,C,D,E,F,G)],verdadeiro).
     *
     * @param matricula
     * @return O automóvel em questão ou null caso não haja nenhum automóvel com
     * essa matricula.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public Automovel getAutomovel(String matricula) throws SPException, InterruptedException, Exception {
        Map<String, Term> map = new HashMap();
        map.put("A", sicstus.newTerm(matricula));
        Query q = sicstus.openPrologQuery("demo([automovel(A,B,C,D,E,F,G)],verdadeiro).", map);
        if (q.nextSolution()) {
            int ano;
            try {
                ano = (int) map.get("F").getInteger();
            } catch (Exception e) {
                ano = -1;
            }
            return new Automovel(matricula,
                    map.get("B").toString(),
                    (String) map.get("C").toString(),
                    (String) map.get("D").toString(),
                    (int) map.get("E").getInteger(),
                    ano,
                    (String) map.get("G").toString());
        } else {
            return null;
        }
    }

    /**
     * Obtém todos os automóveis. Utiliza o predicado
     * demo([automovel(A,B,C,D,E,F,G)],verdadeiro).
     *
     * @return Um map que associa cada matricula ao automóvel.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public Map<String, Automovel> getAutomoveis() throws SPException, InterruptedException, Exception {
        Map<String, Automovel> automoveis = new HashMap<>();
        Map<String, Term> map = new HashMap();
        Query q = sicstus.openPrologQuery(
                "demo([automovel(A,B,C,D,E,F,G)],verdadeiro).", map);
        while (q.nextSolution()) {
            int ano;
            try {
                ano = (int) map.get("F").getInteger();
            } catch (Exception e) {
                ano = -1;
            }
            automoveis.put(map.get("A").toString(),
                    new Automovel(
                            map.get("A").toString(), map.get("B").toString(),
                            (String) map.get("C").toString(),
                            (String) map.get("D").toString(),
                            (int) map.get("E").getInteger(),
                            ano,
                            (String) map.get("G").toString()));
        }
        return automoveis;
    }

    /**
     * Obtém todos os automóveis de uma dada marca. Utiliza o predicado
     * demo([automovel(A,marca,C,D,E,F,G)],verdadeiro).
     *
     * @param marca Marca em questão.
     * @return Um map que associa cada matricula ao automóvel.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public Map<String, Automovel> getAutomoveisMarca(String marca) throws SPException, InterruptedException, Exception {
        Map<String, Automovel> automoveis = new HashMap<>();
        Map<String, Term> map = new HashMap();
        map.put("B", this.sicstus.newTerm(marca));
        Query q = sicstus.openPrologQuery("demo([automovel(A,B,C,D,E,F,G)],verdadeiro).", map);
        while (q.nextSolution()) {
            int ano;
            try {
                ano = (int) map.get("F").getInteger();
            } catch (Exception e) {
                ano = -1;
            }
            automoveis.put(map.get("A").toString(),
                    new Automovel(map.get("A").toString(), map.get("B").toString(),
                            (String) map.get("C").toString(),
                            (String) map.get("D").toString(),
                            (int) map.get("E").getInteger(),
                            ano,
                            (String) map.get("G").toString()));
        }
        return automoveis;
    }

    /**
     * Obtém todos os automóveis de um dado ano. Utiliza o predicado
     * demo([automovel(A,B,C,D,E,ano,G)],verdadeiro).
     *
     * @param ano Ano em questão.
     * @return Um map que associa cada matricula ao automóvel.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public Map<String, Automovel> getAutomoveisAno(int ano) throws SPException, InterruptedException, Exception {
        Map<String, Automovel> automoveis = new HashMap<>();
        Map<String, Term> map = new HashMap();
        map.put("F", this.sicstus.newTerm(ano));
        Query q = sicstus.openPrologQuery("demo([automovel(A,B,C,D,E,F,G)],verdadeiro).", map);
        while (q.nextSolution()) {
            automoveis.put(map.get("A").toString(),
                    new Automovel(map.get("A").toString(), map.get("B").toString(),
                            (String) map.get("C").toString(),
                            (String) map.get("D").toString(),
                            (int) map.get("E").getInteger(),
                            (int) map.get("F").getInteger(),
                            (String) map.get("G").toString()));
        }
        return automoveis;
    }

    /**
     * Obtém todos os automóveis de um dado dono. Utiliza o predicado
     * demo([automovel(A,marca,C,D,E,F,G)],verdadeiro).
     *
     * @param dono O dono em questão.
     * @return Um map que associa cada matricula ao automóvel.
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public Map<String, Automovel> getAutomoveisDono(String dono) throws SPException, InterruptedException, Exception {
        Map<String, Automovel> automoveis = new HashMap<>();
        Map<String, Term> map = new HashMap();
        map.put("G", this.sicstus.newTerm(dono));
        Query q = sicstus.openPrologQuery("demo([automovel(A,B,C,D,E,F,G)],verdadeiro).", map);
        while (q.nextSolution()) {
            int ano;
            try {
                ano = (int) map.get("F").getInteger();
            } catch (Exception e) {
                ano = -1;
            }
            automoveis.put(map.get("A").toString(),
                    new Automovel(map.get("A").toString(), map.get("B").toString(),
                            (String) map.get("C").toString(),
                            (String) map.get("D").toString(),
                            (int) map.get("E").getInteger(),
                            ano,
                            (String) map.get("G").toString()));
        }
        return automoveis;
    }

    /**
     * Verifica o valor de verdade de um dado conjunto de automóveis.
     * demo([automovel(A,B,C,D,E,F,G),...],V).
     *
     * @param automoveis Conjunto de automoveis a testar.
     * @return Um dos três valores de verdade possível, verdade, falso e
     * desconhecido
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public ValorVerdade testeAutomoveis(Collection<Automovel> automoveis) throws SPException, InterruptedException, Exception {
        //construir a query
        String query = "demo([";
        for (Automovel aut : automoveis) {
            query += String.format("automovel('%s','%s','%s','%s',%d,%d,'%s'),",
                    aut.getMatricula(),
                    aut.getMarca(),
                    aut.getModelo(),
                    aut.getCor(),
                    aut.getEstado(),
                    aut.getAno(),
                    aut.getDono());
        }
        //remover a virgula extra
        query = query.substring(0, query.length() - 1);
        query += "],B).";
        //inicializar termo e query ao prolog
        Term t = this.sicstus.prologReadFromString(query, null);
        Map<String, Term> m = new HashMap();
        m.put("A", t);
        this.sicstus.query(query, m);
        //ver resposta
        String resposta = m.get("B").toString();
        switch (resposta) {
            case "verdadeiro":
                return ValorVerdade.VERDADE;
            case "falso":
                return ValorVerdade.FALSO;
            case "desconhecido":
                return ValorVerdade.DESCONHECIDO;
            default:
                throw new Exception("Valor inesperado na resposta!");
        }
    }

    /**
     * Obtém todos os automóveis de um dado dono. Utiliza o predicado
     * demo([automovel(A,B,C,D,E,F,G)],V).
     *
     * @param automovel O automóvel a testar.
     * @return Um dos três valores de verdade possível, verdade, falso e
     * desconhecido
     * @throws SPException Caso o Jasper encontre um problema.
     * @throws InterruptedException Caso o Jasper encontre um problema.
     * @throws Exception Caso o Jasper encontre um problema.
     */
    public ValorVerdade testeAutomoveis(Automovel automovel) throws SPException, InterruptedException, Exception {
        //construir a query
        String query = String.format("demo([automovel('%s','%s','%s','%s',%d,%d,'%s')],B).",
                automovel.getMatricula(),
                automovel.getMarca(),
                automovel.getModelo(),
                automovel.getCor(),
                automovel.getEstado(),
                automovel.getAno(),
                automovel.getDono());
        //inicializar termo e query ao prolog
        Term t = this.sicstus.prologReadFromString(query, null);
        Map<String, Term> m = new HashMap();
        m.put("A", t);
        this.sicstus.query(query, m);
        //ver resposta
        String resposta = m.get("B").toString();
        switch (resposta) {
            case "verdadeiro":
                return ValorVerdade.VERDADE;
            case "falso":
                return ValorVerdade.FALSO;
            case "desconhecido":
                return ValorVerdade.DESCONHECIDO;
            default:
                throw new Exception("Valor inesperado na resposta!");
        }
    }
}
