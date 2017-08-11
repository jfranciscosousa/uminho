


import controller.BetESSAPI;
import models.Apostador;
import models.Bookie;
import models.Evento;
import models.Odd;

public class ServiceBetAPITest {

    public static void main(String[] args) {

        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();

        Bookie bookie1 = casaApostas.registaBookie();
        
        
        // Criar dois eventos na casa de apostas
        Evento evento1 = casaApostas.registaEvento(bookie1);
        casaApostas.actualizaOdd(evento1, 1, 2, 3);
        Evento evento2 = casaApostas.registaEvento(bookie1);
        casaApostas.actualizaOdd(evento2,1, 5, 3);


        Evento evento3 = casaApostas.registaEvento();
        evento3.setOdd(new Odd(1,5,3));

        // Registar dois apostadores
        Apostador apostador1 = casaApostas.registaApostador();
        casaApostas.actualizaApostador(apostador1);
        casaApostas.viewApostadores();
        casaApostas.deleteApostador(apostador1);
        casaApostas.viewApostadores();

        casaApostas.viewEventos();
        casaApostas.viewApostadores();

        // Registar apostas
        casaApostas.registaAposta(apostador1, evento1);
        casaApostas.registaAposta(apostador1, evento2);

        // fechar eventos
        casaApostas.fechaEvento(evento1, 'x', bookie1);
        casaApostas.fechaEvento(evento2, 'x', bookie1);
    }

}
