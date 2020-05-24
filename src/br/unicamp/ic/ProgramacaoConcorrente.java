package br.unicamp.ic;

/*
 * 
 * 
 * 
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProgramacaoConcorrente {
	
	static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(exec(new ValorSemNada()));
        System.out.println(exec(new ValorSynchronized()));
        System.out.println(exec(new ValorReentrantReadWriteLock()));
        System.out.println(exec(new ValorAtomicLong()));
        System.out.println(exec(new ValorLongAdder()));
        System.out.println(exec(new ValorLongAccumulator()));
        
        // FINALIZA OS MODULOS EXECUTORES DE FORMA ORDENADA
        executor.shutdown();
    }

    public static long exec(Valor v) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            executor.submit(() -> v.adicao(1));
        }
        // AGUARDA TODAS AS TAREFAS SUBMETIDAS AO EXECUTOR SEREM FINALIZADAS
        executor.awaitTermination(8, TimeUnit.SECONDS);
        return v.getValor();
    }

    interface Valor {
        long adicao(long v);
        long getValor();
    }

    static class ValorSemNada implements Valor {

        long valor;

        @Override
        public long adicao(long v) {
            this.valor += v;
            return this.valor;
        }

        @Override
        public long getValor() {
            return valor;
        }
    }
    
    // MANTEM UM ENFILEIRAMENTO DE TRHEADS E DEIXA A APLICACAO MTO LENTA EM ALGUNS CASOS
    static class ValorSynchronized implements Valor {

        long valor;

        @Override
        public synchronized long adicao(long v) {
            this.valor += v;
            return this.valor;
        }

        @Override
        public long getValor() {
            return valor;
        }
    }
    
    // CLASSES DO TIPO LOCK PERMITE DEFINIR UM TIMEOUT DE ESPERA
    static class ValorReentrantReadWriteLock implements Valor {

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        long valor;

        @Override
        public long adicao(long v) {
            try {
                lock.writeLock().tryLock(10, TimeUnit.SECONDS);
                this.valor += v;
                return this.valor;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return valor;
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public long getValor() {
            return valor;
        }
    }

    static class ValorAtomicLong implements Valor {

        private AtomicLong atomic = new AtomicLong(0L);

        @Override
        public long adicao(long v) {
            return this.atomic.addAndGet(v);
        }

        @Override
        public long getValor() {
            return this.atomic.get();
        }
    }

    static class ValorLongAdder implements Valor {

        private LongAdder adder = new LongAdder();

        @Override
        public long adicao(long v) {
            this.adder.add(v);
            return 0;
        }

        @Override
        public long getValor() {
            return this.adder.sumThenReset();
        }
    }

    static class ValorLongAccumulator implements Valor {

        private LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0L);

        @Override
        public long adicao(long v) {
            this.accumulator.accumulate(v);
            return this.accumulator.get();
        }

        @Override
        public long getValor() {
            return this.accumulator.get();
        }
    }

}
