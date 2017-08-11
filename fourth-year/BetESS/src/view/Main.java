/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import logic.Bet;
import logic.BetESS;
import logic.Bookie;
import logic.Game;
import logic.Result;
import logic.User;
import logic.exceptions.GameAlreadyFinishedException;
import logic.exceptions.GameDoesntExist;
import logic.exceptions.UserNotRegistered;
import logic.predicates.BetPredicates;
import logic.predicates.GamePredicates;

/**
 *
 * @author joses
 */
public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static final BetESS app = new BetESS();
    private static User currentUser;
    private static boolean isAdmin;

    /**
     * @param args the command line arguments
     * @throws logic.exceptions.GameDoesntExist
     * @throws logic.exceptions.UserNotRegistered
     */
    public static void main(String[] args) throws GameDoesntExist, UserNotRegistered, Exception {
        test();

        initialMenu();
    }

    private static void test() throws Exception {
        //Lista de predicados
        List<Predicate<Bet>> betPredicates = new LinkedList<>();
        List<Predicate<Game>> gamePredicates = new LinkedList<>();

        //este predicado da match com todos as apostas de mais de 20 creditos
        betPredicates.add(new BetPredicates.ValueGreaterPredicate(20));
        //este predicado da match com todas as apostas de menos de 50 creditos
        betPredicates.add(new BetPredicates.ValueLessPredicate(50));

        //criar dois bookies para exemplo
        app.registerBookie("Fernando", "fernando@gmail.com", "1234", 50);
        app.registerBookie("José", "jose@gmail.com", "1234", 50);
        app.registerUser("Nuno", "nuno@gmail.com", "1234", 500);
        Bookie fernando = (Bookie) app.authenticateUser("fernando@gmail.com", "1234");
        Bookie jose = (Bookie) app.authenticateUser("jose@gmail.com", "1234");
        User nuno = app.authenticateUser("nuno@gmail.com", "1234");
        //criar dois jogos
        app.newFootballGame(fernando, "Bayern", "Chelski", 5.7f, 4.5f, 3.2f, LocalDateTime.now().plusDays(10));
        app.newFootballGame(jose, "Benfica", "Bayern", 5.7f, 4.5f, 3.2f, LocalDateTime.now().plusDays(40));
        app.newFootballGame(jose, "Benfica", "Porto", 1.2f, 2.3f, 3.2f, LocalDateTime.now().plusDays(100));
        app.newFootballGame(jose, "Porto", "Benfica", 3.2f, 2.3f, 1.2f, LocalDateTime.now().plusDays(110));
        app.newFootballGame(jose, "Porto", "Braga", 3.2f, 2.3f, 1.2f, LocalDateTime.now().plusDays(119));

        System.out.println("TODOS OS JOGOS");
        PrintUtils.print(app.getGames());
        System.out.println("---------------------------------------------------");

        //procura dado uma lista de predicados (faz um OU com todos os predicados)
        System.out.println("Todos os jogos do Bayern");
        //este predicado da match com todos os jogos em o bayern joga em casa ou fora
        gamePredicates.add(new GamePredicates.HomeTeamPredicate("Bayern"));
        gamePredicates.add(new GamePredicates.AwayTeamPredicate("Bayern"));
        Predicate<Game> bayernPredicate = Predicates.or(gamePredicates);
        PrintUtils.print(app.searchGames(bayernPredicate));

        //adicionar (AND) novo predicado (da match com os jogos criados pelo bookie jose)
        Predicate<Game> bayernJanuaryJosePredicate = Predicates.and(bayernPredicate, new GamePredicates.BookiePredicate("jose@gmail.com"));
        //adicionar (AND) novo predicado (da match com os jogos feitos em JANEIRO)
        bayernJanuaryJosePredicate = Predicates.and(bayernJanuaryJosePredicate, new GamePredicates.MonthPredicate(Month.JANUARY));
        //procura (jogos criados por jose AND jogos da equipa Bayern no mês de Dezembro)
        System.out.println("Todos os jogos criados pelo José onde o Bayern joga feitos no mês de Janeiro");
        PrintUtils.print(app.searchGames(Predicates.and(bayernJanuaryJosePredicate)));

        //testar lista oods
        app.setGameOdds(1, 5.8f, 4.6f, 3.1f);
        Thread.sleep(1000);
        app.setGameOdds(1, 5.1f, 4.0f, 3.2f);

        //fazer umas apostas
        app.newFootballBet(1, 50, Result.HOME, "nuno@gmail.com");
        app.newFootballBet(2, 80, Result.HOME, "nuno@gmail.com");

        System.out.println("Histórico de odds do jogo 1");
        PrintUtils.print(app.getGame(1).getHistoricOdds().entrySet());
        System.out.println("Notificações do Fernando");
        PrintUtils.print(fernando.getMessages());
        System.out.println("Todas as apostas acima de 20 créditos e menores de 50 creditos");
        PrintUtils.print(app.searchBets(Predicates.and(betPredicates)));

        //deve ter um balance de 370
        System.out.println("Saldo do Nuno antes dos jogos acabarem:");
        System.out.println(nuno.getBalance());

        //finalizar jogos
        app.setGameScore(1, 2, 1);
        app.setGameScore(2, 2, 3);

        //perdeu uma aposta, mas ganhou uma cuja a ODD era de 5.1, ou seja
        //ganhos = 5,1*50, ficando com um balance de 625
        System.out.println("Saldo do Nuno depois dos jogos acabarem:");
        System.out.println(nuno.getBalance());
        System.out.println("Notificações do Nuno");
        PrintUtils.print(nuno.getMessages());

        //Mais predicates
        //Predicado que dá match com os jogos em que o bayern ganha
        List<Predicate<Game>> bayernWins = new LinkedList<>();
        bayernWins.add(Predicates.and(new GamePredicates.HomeTeamPredicate("Bayern"), new GamePredicates.ResultPredicate(Result.HOME)));
        bayernWins.add(Predicates.and(new GamePredicates.AwayTeamPredicate("Bayern"), new GamePredicates.ResultPredicate(Result.AWAY)));
        System.out.println("Jogos em que o bayern ganha:");
        PrintUtils.print(app.searchGames(Predicates.or(bayernWins)));
        
        PrintUtils.print(app.getGame(1).getObservers());
    }

    private static void initialMenu() {
        boolean exitFl = false;
        while (true) {
            System.out.println("1-Criar uma conta");
            System.out.println("2-Criar Booker");
            System.out.println("3-Login");
            System.out.println("0-Sair");
            try {
                int opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                        registerMenu();
                        break;
                    case 3:
                        loginMenu();
                        break;
                    case 2:
                        registerMenuBookie();
                        break;
                    case 0:
                        exitFl = true;
                        break;
                    default:
                        System.out.println("Opção inválida tente outra vez!");
                        initialMenu();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Valor Invalido");
                continue;
            }
            if (exitFl == true) {
                break;
            }
        }
    }

    private static void accountMenu() {
        int in;
        boolean exitFlag = false;
        System.out.println("\n\n");
        while (true) {
            System.out.format("Saldo atual:%f\n", currentUser.getBalance());
            System.out.println("Escolha uma opção:");

            System.out.println("1 - Ver Jogos");
            System.out.println("2 - Realizar aposta");
            System.out.println("3 - Adicionar Creditos");
            System.out.println("4 - Ver Histórico de Odds de um Jogo");

            System.out.println("0 - Sair");
            try {
                in = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Opçao invalida");
                continue;
            }

            switch (in) {
                case (0):
                    exitFlag = true;
                    break;
                case (1):
                    getGamesMenu();
                    break;
                case (2):
                    betGameMenu();
                    break;
                case (3):
                    addCreditMenu();
                    break;
                case (4):
                    oddsHistory();
                    break;
                default:
                    System.out.println("Comando invalido");
            }
            if (exitFlag == true) {
                break;
            }
        }
        System.out.println("A sair...");
    }

    private static void getGamesMenu() {
        //boolean showFinish;
        Collection<Game> games = app.getGames();
        while (true) {
            System.out.println("Quer aplicar um filtro aos resultados?(S/N");

            String opt = scan.nextLine();
            if (opt.equals("S") || opt.equals("s")) {
                setFiltersMenu();
                break;
            } else if (opt.equals("N") || opt.equals("n")) {
                //showFinish=true;
                    /*for (Game game : games) {
                     System.out.println(game.toString());
                     System.out.println();
                     }*/
                PrintUtils.print(games);
                break;
            } else {
                System.out.println("Resposta inválida.");
            }
        }
        System.out.println("Concluido.\n\n");
    }

    private static void setFiltersMenu() {
        ArrayList<Predicate<Game>> predicates = new ArrayList<>();
        int i, month;
        boolean exitFlag = false;
        String inputS;
        while (true) {
            System.out.println("Que tipo de filtro pretende adicionar?");

            //System.out.println("1 - Mostrar Apenas jogos a decorrer");
            System.out.println("1 - Mostrar Jogos de uma equipa");
            System.out.println("2 - Mostrar Jogos de um booker");
            System.out.println("3 - Mostrar jogos que vão decorrer num determinado mes");
            System.out.println("0 - Concluir");

            try {
                i = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("opção invalida");
                continue;
            }
            switch (i) {
                case 0:
                    exitFlag = true;
                    break;

                case 1:
                    System.out.println("Insira o nome da equipa");
                    inputS = scan.nextLine();
                    List<Predicate<Game>> teamPredicate = new ArrayList<>();
                    teamPredicate.add(new GamePredicates.HomeTeamPredicate(inputS));
                    teamPredicate.add(new GamePredicates.AwayTeamPredicate(inputS));
                    predicates.add(Predicates.or(teamPredicate));
                    break;
                case 2:
                    System.out.println("insira o email do booker.");
                    inputS = scan.nextLine();
                    predicates.add(new GamePredicates.BookiePredicate(inputS));
                    break;
                case 3:
                    System.out.println("Inseriri numero do mes.");
                    month = scan.nextInt();
                    scan.nextLine();
                    predicates.add(new GamePredicates.MonthPredicate(Month.of(month)));
                    System.out.println(Month.of(month));
                    break;
                default:
                    System.out.println("Valor invalido");

            }
            if (exitFlag == true) {
                break;
            }

        }
        PrintUtils.print(app.searchGames(Predicates.and(predicates)));
        //System.out.println(app.searchGames(Predicates.and(predicates)));
    }

    private static void betGameMenu() {
        int id, team;
        String home, away;
        Game game;
        Result result;
        float homeOdd, awayOdd, drawOdd, betValue;

        while (true) {
            System.out.println("Insira o ID do jogo onde quer apostar");
            id = scan.nextInt();
            scan.nextLine();
            try {
                game = app.getGame(id);
                break;
            } catch (GameDoesntExist e) {
                System.out.println(e.getMessage());
            }
        }
        homeOdd = game.getHomeOdd();
        awayOdd = game.getAwayOdd();
        drawOdd = game.getDrawOdd();
        System.out.println("As odds do jogo são:(" + homeOdd + "," + drawOdd + "," + awayOdd + ")");

        while (true) {
            System.out.println("Em que equipa quer apostar");

            System.out.println("1 - " + game.getHomeTeam());
            System.out.println("2 - " + game.getAwayTeam());
            System.out.println("3 - Empate");
            try {
                team = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Opção invalida");
                continue;
            }
            switch (team) {
                case 1:
                    result = Result.HOME;
                    break;
                case 2:
                    result = Result.AWAY;
                    break;
                case 3:
                    result = Result.DRAW;
                    break;
                default:
                    System.out.println("Opção invalida");
                    continue;
            }
            break;
        }
        while (true) {
            System.out.println("O seu saldo é" + currentUser.getBalance());
            System.out.println("Qual o valor da aposta?");
            try {
                betValue = scan.nextFloat();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Valor invalido");
                continue;
            }
            if (currentUser.getBalance() >= betValue) {
                try {
                    app.newFootballBet(game.getID(), betValue, result, currentUser.getEmail());
                    System.out.println("Aposta realizada com sucesso");
                } catch (GameDoesntExist | UserNotRegistered ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Aposta não foi realizada");
                }
                break;
            } else {
                System.out.println("Não tem saldo suficiente para realizar a aposta.");
                continue;
            }
        }
    }

    private static void addCreditMenu() {
        float value;
        System.out.println("Qual o valor a creditar?");
        try {
            value = scan.nextFloat();
            scan.nextLine();
            currentUser.addBalance(value);
            System.out.println("Valor creditano na conta.");
        } catch (Exception e) {
            System.out.println("Valor invalido");
        }
    }

    private static void registerMenu() {
        System.out.println("Introduza o seu nome");
        String name = scan.nextLine();
        System.out.println("Introduza o seu email");
        String email = scan.nextLine();
        System.out.println("Introduza a sua password");
        String password = scan.nextLine();
        app.registerUser(name, email, password, 0);
    }

    private static void registerMenuBookie() {
        System.out.println("Introduza o seu nome");
        String name = scan.nextLine();
        System.out.println("Introduza o seu email");
        String email = scan.nextLine();
        System.out.println("Introduza a sua password");
        String password = scan.nextLine();
        app.registerBookie(name, email, password, 0);
    }

    private static void loginMenu() {
        try {
            System.out.println("Introduza o seu email");
            String email = scan.nextLine();
            System.out.println("Introduza a sua password");
            String password = scan.nextLine();
            User user = app.authenticateUser(email, password);
            if (user == null) {
                System.out.println("Combinação entre email e password errada!");
            } else {
                currentUser = user;
                System.out.println("Sucesso!");
                if (user instanceof Bookie) {
                    bookieMenu();
                } else {
                    accountMenu();
                }
            }
            //return mainMenu
        } catch (UserNotRegistered ex) {
            System.out.println("Combinação entre email e password errada!");
        }
    }

    private static void bookieMenu() {
        int in;
        boolean exitFlag = false;
        System.out.println("\n\n");
        while (true) {
            System.out.println("Escolha uma opção:");

            System.out.println("1 - Criar Jogo");
            System.out.println("2 - Finalizar Jogo");
            System.out.println("3 - Listar Jogos");
            System.out.println("4 - Alterar odds de um jogo");
            System.out.println("5 - Ver Histórico de Odds de um Jogo");
            System.out.println("6 - Ver Mensagens");

            System.out.println("0 - Sair");

            in = scan.nextInt();
            scan.nextLine();
            switch (in) {
                case (0):
                    exitFlag = true;
                    break;
                case (1):
                    createGameMenu();
                    break;
                case (2):
                    finalizeGameMenu();
                    break;
                case (3):
                    getGamesMenu();
                    break;
                case (4):
                    changeOddsMenu();
                    break;
                case (5):
                    oddsHistory();
                    break;
                case (6):
                    System.out.println(currentUser.getMessages());
                    break;
                default:
                    System.out.println("Comando invalido");
            }
            if (exitFlag == true) {
                break;
            }
        }
        System.out.println("A sair...");
    }

    private static void changeOddsMenu() {
        int game;
        float hodd, dodd, aodd;
        System.out.println("Insira o id do Jogo");
        try {
            game = scan.nextInt();
            scan.nextLine();
            app.getGame(game);
        } catch (GameDoesntExist ex) {
            System.out.println(ex.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Id invalida");
            return;
        }
        System.out.println("Insira o odds da equipa de Casa");
        try {
            hodd = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Odd invalida");
            return;
        }
        System.out.println("Insira o odds da equipa de Visitante");
        try {
            aodd = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Odd invalida");
            return;
        }
        System.out.println("Insira o odds de empate");
        try {
            dodd = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Odd invalida");
            return;
        }
        try {
            app.setGameOdds(game, hodd, dodd, aodd);
        } catch (GameDoesntExist ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void createGameMenu() {
        String homeTeam, awayTeam;
        float homeOdd, awayOdd, drawOdd;
        LocalDateTime date;
        int day, month, year, hour, minute;

        System.out.println("Insira o nome da equipa que joga em casa");
        homeTeam = scan.nextLine();
        System.out.println("Insira o nome da equipa visitante");
        awayTeam = scan.nextLine();
        while (true) {
            try {
                System.out.println("Insira a Odd de vitoria da equipa da casa.");
                homeOdd = scan.nextFloat();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira a Odd de vitoria da equipa visitante.");
                awayOdd = scan.nextFloat();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira a Odd de empate.");
                drawOdd = scan.nextFloat();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira o ano em que se realiza o jogo.");
                year = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira o mes em que se realiza o jogo.");
                month = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira o dia em que se realiza o jogo.");
                day = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira a hora em que se realiza o jogo.");
                hour = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            try {
                System.out.println("Insira o minuto em que começa o jogo.");
                minute = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        date = LocalDateTime.of(year, month, day, hour, minute);

        app.newFootballGame((Bookie) currentUser, homeTeam, awayTeam, homeOdd, drawOdd, awayOdd, date);
    }

    private static void finalizeGameMenu() {
        int id, homeScore, awayScore;
        while (true) {
            System.out.println("Insira o ID do jogo onde quer finalizar");
            try {
                id = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Valor invalido");
                continue;
            }
            try {
                app.getGame(id);
                break;
            } catch (GameDoesntExist e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Insira o numero de golos da equipa que joga em casa.");
            try {
                homeScore = scan.nextInt();
                scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        while (true) {
            System.out.println("Insira o numero de golos da equipa visitante.");
            try {
                awayScore = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Valor invalido");
            }
        }
        try {
            app.setGameScore(id, homeScore, awayScore);
            System.out.println("Concluido...");
        } catch (GameDoesntExist ex) {
            System.out.println(ex.getMessage());
        } catch (GameAlreadyFinishedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void oddsHistory() {
        int id;
        while (true) {
            System.out.println("Insira o ID do jogo onde quer finalizar");
            id = scan.nextInt();
            scan.nextLine();
            try {
                app.getGame(id);
                break;
            } catch (GameDoesntExist e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Histórico de odds do jogo " + id);
        try {
            PrintUtils.print(app.getGame(id).getHistoricOdds().entrySet());
        } catch (GameDoesntExist e) {
            System.out.println(e.getMessage());
        }
    }
}
