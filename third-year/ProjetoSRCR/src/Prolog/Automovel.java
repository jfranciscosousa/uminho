/*
 * Copyright 2015 Nuno Oliveira.
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

/**
 *
 * @author Nuno Oliveira
 */
public class Automovel {

    private String matricula;
    private String marca;
    private String modelo;
    private String cor;
    private int estado;
    private int ano;
    private String dono;

    /**
     *
     * @param matricula
     * @param marca
     * @param modelo
     * @param cor
     * @param estado
     * @param ano
     * @param dono
     */
    public Automovel(String matricula, String marca, String modelo, String cor, int estado, int ano, String dono) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.estado = estado;
        this.ano = ano;
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "Automovel{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", estado=" + estado + ", ano=" + ano + ", dono=" + dono + '}';
    }

    /**
     *
     * @return
     */
    public int getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public String getCor() {
        return cor;
    }

    /**
     *
     * @param cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     *
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     *
     * @return
     */
    public String getDono() {
        return dono;
    }

    /**
     *
     * @param dono
     */
    public void setDono(String dono) {
        this.dono = dono;
    }
}
