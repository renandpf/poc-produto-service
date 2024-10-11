package br.com.pupposoft.poc.monitoriamento.produto.usecase;

import org.springframework.stereotype.Service;

import br.com.pupposoft.poc.monitoriamento.produto.domain.Produto;
import br.com.pupposoft.poc.monitoriamento.produto.exception.ProdutoNaoEncontradoException;
import br.com.pupposoft.poc.monitoriamento.produto.gateway.ProdutoGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ObterProdutoUsecase {

	private ProdutoGateway produtoGateway;

	public Produto obterPorId(Long id) {

		return produtoGateway.obterPorId(id)
				.orElseThrow(() -> {
					log.warn("Produto não encontrado pelo id: {}", id);
					return new ProdutoNaoEncontradoException();
				});
	}
}
