package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jose
 */
public class Odds {

    private float home;
    private float draw;
    private float away;

    /**
     *
     * @param home
     * @param draw
     * @param away
     */
    public Odds(float home, float draw, float away) {
        this.home = home;
        this.draw = draw;
        this.away = away;
    }

    /**
     *
     * @return
     */
    public float getHome() {
        return home;
    }

    /**
     *
     * @return
     */
    public float getDraw() {
        return draw;
    }

    /**
     *
     * @return
     */
    public float getAway() {
        return away;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Float.floatToIntBits(this.home);
        hash = 59 * hash + Float.floatToIntBits(this.draw);
        hash = 59 * hash + Float.floatToIntBits(this.away);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Odds other = (Odds) obj;
        if (Float.floatToIntBits(this.home) != Float.floatToIntBits(other.home)) {
            return false;
        }
        if (Float.floatToIntBits(this.draw) != Float.floatToIntBits(other.draw)) {
            return false;
        }
        if (Float.floatToIntBits(this.away) != Float.floatToIntBits(other.away)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Odd{" + "home=" + home + ", draw=" + draw + ", away=" + away + '}';
    }
}
