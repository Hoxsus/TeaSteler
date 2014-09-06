package nodes;

import org.powerbot.script.rt6.ClientContext;

import methods.Node;

public class UseBank extends Node<ClientContext> {

	public UseBank(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean condition() {
		System.out.println("Condition Node UseBank");
		return ctx.bank.opened() && ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() {
		System.out.println("Execute Node UseBank");
		if (ctx.bank.depositInventory()) {
			ctx.bank.close();
		}
	}

}
