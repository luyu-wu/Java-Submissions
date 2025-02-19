public int Collatz(long n) {
	int ops = 0;
	while (n != 1) {
		if (n%2 == 0){
			n /= 2;
		} else {
			n = n*3 + 1;
		}
		System.out.print(n+" -> ");
		ops ++;
	}

	return ops;
}
