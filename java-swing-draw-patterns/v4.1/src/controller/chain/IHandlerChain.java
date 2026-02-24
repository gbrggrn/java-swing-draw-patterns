package controller.chain;

import java.util.Optional;

import controller.commands.IHandlerCommand;

/**
 * This interface defines each link in the handler-chain.
 */
public interface IHandlerChain {
	void setNext(IHandlerChain next);
	Optional<IHandlerCommand> handle(ChainInfo info);
}
