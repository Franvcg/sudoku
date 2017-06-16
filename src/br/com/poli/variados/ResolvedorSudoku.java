package br.com.poli.variados;

import br.com.poli.exceptions.TabuleiroInvalidoException;

public interface ResolvedorSudoku {
	
	public boolean resolveTabuleiro(int x, int y) throws TabuleiroInvalidoException;
	
}
