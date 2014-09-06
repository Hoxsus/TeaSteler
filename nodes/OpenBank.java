package nodes;

import java.util.concurrent.Callable;

import methods.Node;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

public class OpenBank extends Node<ClientContext> {

	public OpenBank(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean condition() {
		System.out.println("Condition Node OpenBank");
		return ctx.backpack.select().count() == 28 && !ctx.bank.opened();
	}

	@Override
	public void execute() {
		System.out.println("Execute Node OpenBank");
		if (ctx.bank.inViewport() && ctx.bank.open()) {
			Condition.wait(new Callable<Boolean>() {
				public Boolean call() throws Exception {
					return ctx.bank.opened();
				}
			}, 2000, 5000);
		} else {
			ctx.camera.turnTo(ctx.bank.nearest());
			while (!ctx.bank.inViewport()) {
				ctx.movement.findPath(ctx.bank.nearest()).traverse();
			}
		}
	}
}
