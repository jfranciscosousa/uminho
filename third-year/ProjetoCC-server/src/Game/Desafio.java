/* 
 * Copyright (C) 2015 José Sousa & Nuno Carvalho
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Game;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Classe que armazena informações relativas a um desafio, incluíndo o nome do
 * mesmo, a data a que vai começar e as respetivas perguntas.
 *
 * @author José Francisco & Nuno Carvalho
 */
public class Desafio {

    private final String nome;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    private final Perguntas perguntas;
    private final LocalDateTime inicio;
    private final Map<String, Integer> jogadores;
    private final Map<String, LocalDateTime> finalizados;
    //map que associa jogador a pergunta que vai responder - local
    private final Map<String, Integer> jogoaux;

    public Desafio(String nome, String criador, Perguntas perguntas, String inicio) throws DataInvalidaException {
        this.nome = nome;
        this.perguntas = perguntas;
        this.inicio = LocalDateTime.parse(inicio, this.dtf);
        if (LocalDateTime.now().compareTo(this.inicio) > 0) {
            throw new DataInvalidaException();
        }
        this.jogadores = new HashMap<>();
        this.jogadores.put(criador, 0);
        this.finalizados = new HashMap<>();
        this.jogoaux = new HashMap<>();
        this.jogoaux.put(criador, 0);
    }

    public Desafio(String nome, String criador, Perguntas perguntas) {
        this.nome = nome;
        this.perguntas = perguntas;
        this.inicio = LocalDateTime.now().plus(5, ChronoUnit.MINUTES);
        this.jogadores = new HashMap<>();
        this.jogadores.put(criador, 0);
        this.finalizados = new HashMap<>();
        this.jogoaux = new HashMap<>();
        this.jogoaux.put(criador, 0);
    }

    public boolean processResposta(int pergunta, int resposta) {
        return this.perguntas.getPergunta(pergunta).getCerta() == resposta;
    }

    public String getNome() {
        return nome;
    }

    public boolean addJogador(String jogador) {
        //se for um jogador finalizado, nao fazer nada
        if (this.finalizados.containsKey(jogador)) {
            return false;
        }
        this.jogadores.put(jogador, 0);
        this.jogoaux.put(jogador, 0);
        return true;
    }

    public boolean contemJogador(String jogador) {
        return this.jogadores.containsKey(jogador);
    }

    public void addPontuacao(String jogador, int pontuacao) {
        Integer i = this.jogadores.get(jogador);
        if (i != null) {
            i += pontuacao;
        }
        this.jogadores.put(jogador, i);
    }

    public int nrJogadores() {
        return this.jogadores.size();
    }

    public String getData() {
        return this.inicio.format(DateTimeFormatter.ofPattern("yyMMdd"));
    }

    public String getHora() {
        return this.inicio.format(DateTimeFormatter.ofPattern("HHmmss"));
    }

    public double getMinutosToInicio() {
        ZonedDateTime zdt = ZonedDateTime.of(this.inicio, ZoneId.systemDefault());
        GregorianCalendar cal = GregorianCalendar.from(zdt);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) * (1.66666667e-5);
    }

    public boolean podeJogar() {
        LocalDateTime agora = LocalDateTime.now();
        return agora.compareTo(inicio) > 0;
    }

    public int getNumPergunta(String jogador) {
        int num = this.jogoaux.get(jogador);
        return num;
    }

    public void incNumPergunta(String jogador) {
        int num = this.jogoaux.get(jogador);
        this.jogoaux.put(jogador, num + 1);
    }

    public Pergunta getPergunta(int id) {
        return this.perguntas.getPergunta(id);
    }

    public LocalDateTime getLDTime() {
        return this.inicio;
    }

    public Set<Entry<String, Integer>> getPontuacoes() {
        return this.jogadores.entrySet();
    }

    public void removerJogador(String jogador){
        this.jogadores.remove(jogador);
        this.finalizados.remove(jogador);
        this.jogoaux.remove(jogador);
    }
    
    /**
     * Atualiza o count de utilizadores que acabaram o desafio
     *
     * @param jogador Jogador a finalizar
     * @return True se removermos o ultimo jogador, para saber que temos que
     * finalizar este desafio
     */
    public boolean finalizaJogador(String jogador) {
        this.finalizados.put(jogador, LocalDateTime.now());
        return this.finalizados.size() == this.jogadores.size();
    }

    public void finalizarDesafio() {
        //colocar todos os jogadores 
        for (String jogador : this.jogadores.keySet()) {
            this.finalizados.putIfAbsent(jogador, LocalDateTime.now());
        }
    }

    public int getJogadores() {
        return this.jogadores.size();
    }

    public int getHighScore() {
        List<Integer> highScores = new ArrayList<>(this.jogadores.values());
        Collections.sort(highScores);
        int highScore = highScores.get(highScores.size() - 1);
        return highScore;
    }

    public String calculaCampeao() {
        if (this.jogadores.size() > 0) {
            Map<String, LocalDateTime> empatados = new HashMap<>();
            int highScore = this.getHighScore();
            //colocar utilizadores empatados no topo da classificaçao num map
            //para ordenar pela data em que acabou o desafio        
            for (Entry<String, Integer> entry : this.jogadores.entrySet()) {
                if (entry.getValue() == highScore) {
                    empatados.put(entry.getKey(), this.finalizados.get(entry.getKey()));
                }
            }
            //ordenar pela data completada
            empatados = sortByValue(empatados);
            //devolver o primeiro
            String campeao = empatados.keySet().iterator().next();
            this.addPontuacao(campeao, 3);
            return campeao;
        } else {
            return null;
        }
    }

    private static Map sortByValue(Map unsortMap) {
        List list = new LinkedList(unsortMap.entrySet());

        Collections.sort(list, (Object o1, Object o2) -> ((Comparable) ((Map.Entry) (o1)).getValue())
                .compareTo(((Map.Entry) (o2)).getValue()));

        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
