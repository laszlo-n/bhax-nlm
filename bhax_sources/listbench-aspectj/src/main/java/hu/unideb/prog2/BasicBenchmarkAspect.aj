package hu.unideb.prog2;

aspect BasicBenchmarkAspect {
	pointcut measurement(): call(void BasicBenchmarker.measure(*,*));
	
	before(): measurement() {
		System.out.println("Measurement started...");
	}
	
	void around(): measurement() {
		long before = System.nanoTime();
		proceed();
		long after = System.nanoTime();
		System.out.println(String.format("The entire measurement took %d ms.", (long) (after - before) / 1000000));
	}
	
	after(): measurement() {
		System.out.println("Measurement finished.");
	}

}
