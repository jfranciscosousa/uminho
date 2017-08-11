using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjetoLI4 {

    class NumberGenerator {
        private Random rng;
        private readonly int[] primes = { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,    
                                          79,83,89,97,101};

        public NumberGenerator() {
            this.rng = new Random((int)DateTime.Now.Ticks);
        }

        public int randomInt() {
            return rng.Next();
        }

        public int randomInt(int from, int to) {
            return rng.Next(from, to);
        }

        public int randomPrime() {
            return primes[rng.Next(0, primes.Length)];
        }

        public int randomPrime(int upto) {
            if (upto <= 2)
                return -1;
            Boolean done = false;
            int prime = 0;
            while (!done) {
                prime = randomPrime();
                if (prime < upto)
                    done = true;
            }
            return prime;
        }
    }
}