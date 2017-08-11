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
package Main;

import Prolog.Automovel;
import Prolog.ValorVerdade;
import Prolog.Connection;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import se.sics.jasper.SPException;

/**
 *
 * @author Nuno Oliveira
 */
public class Menu {

    private PrintStream out;
    private Scanner in;
    private Connection conn;

    /**
     *
     */
    public Menu() {
        out = System.out;
        in = new Scanner(System.in);
    }

    /**
     *
     * @return
     */
    public boolean StartConnection() {
        boolean start = false;
        try {
            conn = new Connection();
            conn.load("projeto.pl");
            start = true;
        } catch (SPException ex) {
            out.println(ex.getMessage());
        }
        return start;
    }

    /**
     *
     */
    public void menu() {
        int opcao;
        while (true) {
            out.println("**Menu Principal**\n"
                    + "Escolha a opção que pretende:\n"
                    + "1-Adicionar Automovel\n"
                    + "2-Ver Lista de Automoveis\n"
                    + "3-Substituir Automovel\n"
                    + "4-Remover Automovel\n"
                    + "5-Testar Automoveis\n"
                    + "0- Sair");

            try {
                out.println("Escolher opção:");
                opcao = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                out.println("Introduza uma opção válida!");
                in.nextLine();
                continue;
            }

            switch (opcao) {
                case (0):
                    System.exit(0);
                    break;
                case (1):
                    menuAdicionar();
                    break;
                case (2):
                    verListaAutomoveis();
                    break;
                case (3):
                    substituirAuto();
                    break;
                case (4):
                    removerAuto();
                    break;
                case (5):
                    testaAutomovel();
                    break;
                default:
                    out.println("Introduza uma opção válida!");
                    in.nextLine();
            }
        }

    }

    /**
     *
     */
    public void menuAdicionar() {

        String matricula, marca, modelo, cor, dono;
        int ano, estado;
        out.println("Inserir automóvel.");
        out.println("Matrícula:");
        matricula = in.nextLine();
        out.println("Marca:");
        marca = in.nextLine();
        out.println("Modelo: ");
        modelo = in.nextLine();
        out.println("Cor: ");
        cor = in.nextLine();

        while (true) {
            try {
                out.println("Ano: ");
                ano = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                out.println("Introduza um ano válido!");

            }
        }
        while (true) {
            try {
                out.println("Estado: ");
                estado = Integer.parseInt(in.nextLine());
                if (estado > 0 && estado <= 10) {
                    break;
                } else {
                    out.println("Introduza um estado válido! (entre 0 e 10)");
                }
            } catch (Exception e) {
                out.println("Introduza um estado válido!");

            }
        }
        out.println("Dono: ");
        dono = in.nextLine();
        Automovel automovel = new Automovel(matricula, marca, modelo, cor, estado, ano, dono);
        try {
            if (conn.addAutomovel(automovel)) {
                out.println("Automóvel adicionado com sucesso");
            } else {
                out.println("Erro - Impossivel adicionar este automóvel");
            }
        } catch (SPException ex) {
            out.println(ex.getMessage());
        }
    }

    /**
     *
     */
    public void verListaAutomoveis() {
        int opcao;
        HashMap<String, Automovel> lista = new HashMap<>();
        Automovel a;
        while (true) {
            out.println("**Procurar Automoveis**");
            out.println("Procurar automoveis por:");
            out.println("1- Mostrar todos.\n"
                    + "2- Procurar por Matricula.\n"
                    + "3- Procurar por marca.\n"
                    + "4- Procurar pod Ano.\n"
                    + "5- Procurar por dono.\n"
                    + "0- Retroceder");

            try {
                out.println("Escolher opção:");
                opcao = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                out.println("Introduza uma opção válida!");
                in.nextLine();
                continue;
            }

            switch (opcao) {
                case (0):
                    return;
                case (2):
                    out.println("Inserir Matricula:");
                    try {
                        a = conn.getAutomovel(in.nextLine());
                        out.println("- Matricula: " + a.getMatricula() + " Marca: " + a.getMarca() + " Modelo: " + a.getModelo() + " Cor: " + a.getCor() + " Ano: " + a.getAno() + " Estado: " + a.getEstado() + " Dono: " + a.getDono());
                    } catch (InterruptedException ex) {
                        out.println(ex.getMessage());
                    } catch (Exception ex) {
                        out.println("Nao existe carro com a matricula apresentada");
                    }

                    break;
                case (3):
                    out.println("Inserir Marca:");
                    try {
                        lista = (HashMap<String, Automovel>) conn.getAutomoveisMarca(in.nextLine());
                        printList(lista);
                    } catch (InterruptedException ex) {
                        out.println(ex.getMessage());
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }
                    break;
                case (1):
                    try {
                        lista = (HashMap<String, Automovel>) conn.getAutomoveis();
                        printList(lista);
                    } catch (InterruptedException ex) {
                        out.println(ex.getMessage());
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }
                    break;
                case (4):
                    out.println("Inserir Ano:");
                    try {
                        lista = (HashMap<String, Automovel>) conn.getAutomoveisAno(Integer.parseInt(in.nextLine()));
                        printList(lista);
                    } catch (InterruptedException ex) {
                        out.println(ex.getMessage());
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }

                    break;
                case (5):
                    out.println("Inserir Dono:");
                    try {
                        lista = (HashMap<String, Automovel>) conn.getAutomoveisDono(in.nextLine());
                        printList(lista);
                    } catch (InterruptedException ex) {
                        out.println(ex.getMessage());
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }
                    break;
                default:
                    out.println("Introduza uma opção válida!");
                    in.nextLine();
            }
            return;
        }

    }

    private void substituirAuto() {

        Automovel a;
        String matricula, marca, modelo, cor, dono;
        int ano, estado;
        out.println("Inserir Matricula:");

        try {
            a = conn.getAutomovel(in.nextLine());
            out.println("- Matricula: " + a.getMatricula() + " Marca: " + a.getMarca() + " Modelo: " + a.getModelo() + " Cor: " + a.getCor() + " Ano: " + a.getAno() + " Estado: " + a.getEstado() + " Dono: " + a.getDono());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            out.println(ex.getMessage());
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
            out.println(ex.getMessage());
            return;
        }
        out.println("Deseja substituir? (S/N)");
        while (true) {
            switch (in.nextLine()) {
                case ("S"):
                    break;
                case ("N"):
                    return;
                default:
                    out.println("Opção invalida, insira novamente:");
                    continue;
            }
            break;
        }

        out.println("Inserir novos dados.");

        out.println("Marca:");
        marca = in.nextLine();
        out.println("Modelo: ");
        modelo = in.nextLine();
        out.println("Cor: ");
        cor = in.nextLine();

        while (true) {
            try {
                out.println("Ano: ");
                ano = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                out.println("Introduza um ano válido!");

            }
        }
        while (true) {
            try {
                out.println("Estado: ");
                estado = Integer.parseInt(in.nextLine());
                if (estado > 0 && estado <= 10) {
                    break;
                } else {
                    out.println("Introduza um estado válido! (entre 0 e 10)");
                }

            } catch (Exception e) {
                out.println("Introduza um estado válido!");

            }
        }
        out.println("Dono: ");
        dono = in.nextLine();
        Automovel automovel = new Automovel(a.getMatricula(), marca, modelo, cor, estado, ano, dono);
        try {
            if (conn.alterarAutomovel(automovel)) {
                out.println("Automóvel substituido com sucesso");
            } else {
                out.println("Erro - Impossivel substituir este automóvel");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            out.println(ex.getMessage());

        }
    }

    private void removerAuto() {
        out.println("Inserir Matricula:");

        String mat = in.nextLine();
        try {
            if (conn.removeAutomovel(mat)) {
                out.println("O Automovel com a matricula " + mat + " foi removido com sucesso.");
            } else {
                out.println("O Automovel com a matricula " + mat + " não existe ou não pode ser removido.");
            }
        } catch (SPException ex) {
            out.println(ex.getMessage());
            out.println("O Automovel com a matricula " + mat + " não existe ou não pode ser removido.");
        }
    }

    private void testaAutomovel() {
        String matricula, marca, modelo, cor, dono;
        int ano, estado;
        out.println("Inserir dados do automóvel.");
        out.println("Matrícula:");
        matricula = in.nextLine();
        out.println("Marca:");
        marca = in.nextLine();
        out.println("Modelo: ");
        modelo = in.nextLine();
        out.println("Cor: ");
        cor = in.nextLine();

        while (true) {
            try {
                out.println("Ano: ");
                ano = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                out.println("Introduza um ano válido!");

            }
        }
        while (true) {
            try {
                out.println("Estado: ");
                estado = Integer.parseInt(in.nextLine());
                if (estado > 0 && estado <= 10) {
                    break;
                } else {
                    out.println("Introduza um estado válido! (entre 0 e 10)");
                }
            } catch (Exception e) {
                out.println("Introduza um estado válido!");

            }
        }
        out.println("Dono: ");
        dono = in.nextLine();
        Automovel automovel = new Automovel(matricula, marca, modelo, cor, estado, ano, dono);
        ValorVerdade teste;
        try {
            teste = conn.testeAutomoveis(automovel);
            if (teste == ValorVerdade.VERDADE) {
                out.println("O Automovel apresentado existe.");
            } else if (teste == ValorVerdade.FALSO) {
                out.println("O Automovel apresentado não existe.");
            } else {
                out.println("Não se sabe se o automovel existe.");
            }
        } catch (InterruptedException ex) {
            out.println(ex.getMessage());
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }

    }

    private void printList(HashMap<String, Automovel> list) {
        out.println("Lista:");
        int cont = 0;
        for (Automovel a : list.values()) {
            if (a.getAno() < 0) {
                out.println(++cont + "- Matricula: " + a.getMatricula() + " Marca: " + a.getMarca() + " Modelo: " + a.getModelo() + " Cor: " + a.getCor() + " Ano: desconhecido" + " Estado: " + a.getEstado() + " Dono: " + a.getDono());
            } else {
                out.println(++cont + "- Matricula: " + a.getMatricula() + " Marca: " + a.getMarca() + " Modelo: " + a.getModelo() + " Cor: " + a.getCor() + " Ano: " + a.getAno() + " Estado: " + a.getEstado() + " Dono: " + a.getDono());
            }
        }
    }

}
